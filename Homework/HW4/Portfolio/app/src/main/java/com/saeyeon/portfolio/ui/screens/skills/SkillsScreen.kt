package com.saeyeon.portfolio.ui.screens.skills


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saeyeon.portfolio.data.model.Skill
import com.saeyeon.portfolio.ui.components.card.SkillCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkillsScreen(navController: NavController) {
    // Material Design layout
    Scaffold(
        // title styling
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Skills",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF55808B)
                    )
                },
                // back button
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF55808B)
                        )
                    }
                },
                // app bar color
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    navigationIconContentColor = Color(0xFF55808B)
                )
            )
        }
    ) { padding ->
        // LazyColumn for scrollable content
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Spacer for top padding
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            // SkillCard for each category
            item {
                SkillCard(
                    category = "Languages",
                    skills = listOf(
                        Skill("Java", 80),
                        Skill("Kotlin", 70),
                        Skill("C", 60),
                        Skill("C#", 30),
                        Skill("Python", 50),
                        Skill("JavaScript", 30),
                    )
                )
            }

            item {
                SkillCard(
                    category = "Backend",
                    skills = listOf(
                        Skill("Spring Boot", 80),
                        Skill("QueryDSL", 50),
                        Skill("Django", 70),
                    )
                )
            }

            item {
                SkillCard(
                    category = "Frontend",
                    skills = listOf(
                        Skill("Android", 80),
                        Skill("HTML5", 70),
                        Skill("CSS3", 60),
                    )
                )
            }

            item {
                SkillCard(
                    category = "DBMS",
                    skills = listOf(
                        Skill("MySql", 80),
                        Skill("Oracle", 70),
                        Skill("Redis", 60),
                    )
                )
            }

            item {
                SkillCard(
                    category = "Tools",
                    skills = listOf(
                        Skill("Git", 80),
                        Skill("Github Actions", 80),
                        Skill("Docker", 80),
                        Skill("Jenkins", 50),
                    )
                )
            }

            item {
                SkillCard(
                    category = "ETC",
                    skills = listOf(
                        Skill("Unity", 50)
                    )
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))  // 하단 여백
            }
        }
    }
}