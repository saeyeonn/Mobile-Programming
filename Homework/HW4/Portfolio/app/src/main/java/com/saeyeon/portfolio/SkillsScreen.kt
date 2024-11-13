package com.saeyeon.portfolio


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkillsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Skill Set") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
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
                SkillCategoryCard(
                    category = "Programming Languages",
                    skills = listOf(
                        Skill("Kotlin", 90),
                        Skill("Java", 85),
                        Skill("Python", 75),
                        Skill("JavaScript", 70)
                    )
                )
            }

            item {
                SkillCategoryCard(
                    category = "Android Development",
                    skills = listOf(
                        Skill("Jetpack Compose", 85),
                        Skill("Android SDK", 90),
                        Skill("MVVM", 85),
                        Skill("Room Database", 80)
                    )
                )
            }

            item {
                SkillCategoryCard(
                    category = "Other Technologies",
                    skills = listOf(
                        Skill("Git", 85),
                        Skill("RESTful APIs", 80),
                        Skill("Firebase", 75),
                        Skill("SQL", 70)
                    )
                )
            }
        }
    }
}

data class Skill(
    val name: String,
    val proficiency: Int
)

@Composable
fun SkillCategoryCard(
    category: String,
    skills: List<Skill>
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
                text = category,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            skills.forEach { skill ->
                SkillItem(skill)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun SkillItem(skill: Skill) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = skill.name,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "${skill.proficiency}%",
                style = MaterialTheme.typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        LinearProgressIndicator(
            progress = skill.proficiency / 100f,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

