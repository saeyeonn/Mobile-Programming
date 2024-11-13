package com.saeyeon.portfolio.ui.screens.awards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saeyeon.portfolio.data.model.Award
import com.saeyeon.portfolio.ui.components.card.AwardCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AwardsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Awards & Achievements") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.Star, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(awards) { award ->
                AwardCard(award)
            }
        }
    }
}

val awards = listOf(
    Award(
        "IT SERVICE PLANNING CONTEST",
        "ITM",
        "2023",
        "Received 2nd award for mobile application planning"
    ),
    Award(
        "IT SERVICE PLANNING CONTEST",
        "ITM",
        "2022",
        "Received 3nd award for mobile application planning"
    ),
    Award(
        "IT SERVICE DEVELOPMENT CONTEST",
        "ITM",
        "2022",
        "Received 3nd award for mobile application development"
    )
)