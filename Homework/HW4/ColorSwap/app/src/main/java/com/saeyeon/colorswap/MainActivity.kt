package com.saeyeon.colorswap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ColorSwapScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorSwapScreen() {
    var colorText by remember { mutableStateOf("Tap to Change Color") }
    var textColor by remember { mutableStateOf(Color.Black) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ColorSwap") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = colorText,
                fontSize = 24.sp,
                color = textColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    val red = Random.nextInt(256)
                    val green = Random.nextInt(256)
                    val blue = Random.nextInt(256)

                    textColor = Color(red, green, blue)
                    colorText = "COLOR: ${red}r, ${green}g, ${blue}b"
                }
            ) {
                Text("TAP ME!")
            }
        }
    }
}