package com.saeyeon.search

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val getSearchResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val message = result.data?.getStringExtra("user_message") ?: ""
            lifecycleScope.launch {
                snackbarHostState.showSnackbar(message)
            }
        }
    }

    private val snackbarHostState = SnackbarHostState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen(getSearchResult, snackbarHostState)
            }
        }
    }
}

@Composable
fun MainScreen(
    getSearchResult: ActivityResultLauncher<Intent>,
    snackbarHostState: SnackbarHostState
) {
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Gray,
                        focusedBorderColor = Color(0xFF673AB7)
                    ),
                    shape = RoundedCornerShape(4.dp)
                )

                Button(
                    onClick = {
                        val searchIntent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                            putExtra(SearchManager.QUERY, searchQuery)
                        }
                        val chooserIntent = Intent.createChooser(
                            searchIntent,
                            "Complete action using"
                        )
                        getSearchResult.launch(chooserIntent)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF673AB7)
                    ),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text("Search")
                }
            }
        }
    }
}