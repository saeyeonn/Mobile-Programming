package com.saeyeon.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saeyeon.portfolio.ui.screens.awards.AwardsScreen
import com.saeyeon.portfolio.ui.screens.education.EducationScreen
import com.saeyeon.portfolio.ui.screens.interests.InterestsScreen
import com.saeyeon.portfolio.ui.screens.profile.ProfileScreen
import com.saeyeon.portfolio.ui.screens.projects.ProjectsScreen
import com.saeyeon.portfolio.ui.screens.skills.SkillsScreen
import com.saeyeon.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContent {
                PortfolioTheme {
                    PortfolioApp()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            android.util.Log.e("MainActivity", "Error in onCreate: ", e)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioApp() {
    val navController = rememberNavController()
    // Scaffold layout
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "My Portfolio",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF48708F),
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        // NavHost layout
        NavHost(
            navController = navController,
            startDestination = "profile",
            modifier = Modifier.padding(padding)
        ) {
            composable("profile") { ProfileScreen(navController) }
            composable("education") { EducationScreen(navController) }
            composable("projects") { ProjectsScreen(navController) }
            composable("awards") { AwardsScreen(navController) }
            composable("skills") { SkillsScreen(navController) }
            composable("interests") { InterestsScreen(navController) }
        }
    }
}