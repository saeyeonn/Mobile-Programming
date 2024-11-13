package com.saeyeon.portfolio

import androidx.compose.material3.DrawerValue
import kotlinx.coroutines.launch
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saeyeon.portfolio.ui.theme.PortfolioTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import com.saeyeon.portfolio.ui.screens.about.AboutScreen
import com.saeyeon.portfolio.ui.screens.activities.ActivitiesScreen
import com.saeyeon.portfolio.ui.screens.awards.AwardsScreen
import com.saeyeon.portfolio.ui.components.dialog.ContactDialog
import com.saeyeon.portfolio.ui.screens.curriculum.CurriculumScreen
import com.saeyeon.portfolio.ui.screens.education.EducationScreen
import com.saeyeon.portfolio.ui.screens.profile.ProfileScreen
import com.saeyeon.portfolio.ui.screens.projects.ProjectsScreen
import com.saeyeon.portfolio.ui.screens.skills.SkillsScreen


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
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    "Profile",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                Divider()
                NavigationDrawerItem(
                    label = { Text("About Me") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            navController.navigate("about")
                        }
                    },
                    icon = { Icon(Icons.Default.Person, contentDescription = null) }
                )
                NavigationDrawerItem(
                    label = { Text("Education") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            navController.navigate("education")
                        }
                    },
                    icon = { Icon(Icons.Default.Star, contentDescription = null) }
                )
                NavigationDrawerItem(
                    label = { Text("Projects") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            navController.navigate("projects")
                        }
                    },
                    icon = { Icon(Icons.Default.Star, contentDescription = null) }
                )

                Divider()

                Text(
                    "Connect with Me",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
                NavigationDrawerItem(
                    label = { Text("Message") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            showDialog = true
                        }
                    },
                    icon = { Icon(Icons.Default.Star, contentDescription = null) }
                )
                NavigationDrawerItem(
                    label = { Text("Email") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            // 이메일 처리
                        }
                    },
                    icon = { Icon(Icons.Default.Email, contentDescription = null) }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My Portfolio") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
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
            NavHost(
                navController = navController,
                startDestination = "profile",
                modifier = Modifier.padding(padding)
            ) {
                composable("profile") { ProfileScreen(navController) { showDialog = true } }
                composable("about") { AboutScreen(navController) }
                composable("education") { EducationScreen(navController) }
                composable("projects") { ProjectsScreen(navController) }
                composable("curriculum") { CurriculumScreen(navController) }
                composable("awards") { AwardsScreen(navController) }
                composable("skills") { SkillsScreen(navController) }
                composable("activities") { ActivitiesScreen(navController) }
            }

            if (showDialog) {
                ContactDialog { showDialog = false }
            }
        }
    }
}