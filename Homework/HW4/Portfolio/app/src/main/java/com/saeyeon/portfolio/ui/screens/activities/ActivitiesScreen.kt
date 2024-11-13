package com.saeyeon.portfolio.ui.screens.activities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.saeyeon.portfolio.data.model.Activity
import com.saeyeon.portfolio.ui.components.card.ActivityCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivitiesScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Activities & Interests") },
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
            item {
                ActivityCard(
                    title = "Volunteering",
                    items = listOf(
                        Activity(
                            title = "Community Teaching",
                            description = "Teaching programming to high school students",
                            period = "2022 - Present",
                            icon = Icons.Default.Star
                        ),
                        Activity(
                            title = "Tech Mentor",
                            description = "Mentoring junior developers in local tech community",
                            period = "2021 - Present",
                            icon = Icons.Default.Star
                        )
                    )
                )
            }

            item {
                ActivityCard(
                    title = "Interests",
                    items = listOf(
                        Activity(
                            title = "Mobile App Development",
                            description = "Creating innovative mobile applications",
                            period = "Ongoing",
                            icon = Icons.Default.Star
                        ),
                        Activity(
                            title = "UI/UX Design",
                            description = "Designing user-friendly interfaces",
                            period = "Ongoing",
                            icon = Icons.Default.Star
                        )
                    )
                )
            }

            item {
                ActivityCard(
                    title = "Hobbies",
                    items = listOf(
                        Activity(
                            title = "Photography",
                            description = "Digital and mobile photography",
                            period = "2019 - Present",
                            icon = Icons.Default.Star
                        ),
                        Activity(
                            title = "Reading",
                            description = "Technical books and science fiction",
                            period = "Ongoing",
                            icon = Icons.Default.Star
                        )
                    )
                )
            }
        }
    }
}



