package com.saeyeon.portfolio.ui.screens.curriculum

import androidx.compose.foundation.layout.*
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurriculumScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Curriculum Vitae") },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            CvSection(
                title = "Personal Information",
                items = listOf(
                    "Name: John Doe",
                    "Email: john.doe@example.com",
                    "Location: Seoul, South Korea"
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            CvSection(
                title = "Technical Skills",
                items = listOf(
                    "Android Development",
                    "Kotlin",
                    "Java",
                    "Git"
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            CvSection(
                title = "Work Experience",
                items = listOf(
                    "Senior Android Developer - Example Corp (2020-Present)",
                    "Android Developer - Tech Company (2018-2020)",
                    "Junior Developer - Startup Inc (2016-2018)"
                )
            )
        }
    }
}

