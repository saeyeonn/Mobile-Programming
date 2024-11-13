package com.saeyeon.portfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

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
                ActivityCategoryCard(
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
                ActivityCategoryCard(
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
                ActivityCategoryCard(
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


data class Activity(
    val title: String,
    val description: String,
    val period: String,
    val icon: ImageVector
)

@Composable
fun ActivityCategoryCard(
    title: String,
    items: List<Activity>
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            items.forEach { activity ->
                ActivityItem(activity)
                if (activity != items.last()) {
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

@Composable
fun ActivityItem(activity: Activity) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = activity.icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Column {
            Text(
                text = activity.title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = activity.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = activity.period,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}