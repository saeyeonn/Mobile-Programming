package com.saeyeon.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioApp()
        }
    }
}


@Composable
fun PortfolioApp() {
    val navController = rememberNavController()

    MaterialTheme {
        NavHost(navController = navController, startDestination = "profile") {
            composable("profile") { ProfileScreen(navController) }
            composable("education") { EducationScreen(navController) }
            composable("projects") { ProjectsScreen(navController) }
        }
    }
}

@Composable
fun ProjectsScreen(navController: NavHostController) {
    TODO("Not yet implemented")
}


@Composable
fun EducationScreen(navController: NavHostController) {
    TODO("Not yet implemented")
}


@Composable
fun ProfileScreen(navController: NavController) {
    var showContactDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Profile Header
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_placeholder),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(120.dp)
                )
                Text(
                    text = "Saeyeon Lim",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = "Spring Developer",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatisticItem(count = "6", label = "New Projects")
            StatisticItem(count = "4", label = "New Skills")
        }

        // Activity Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            item {
                ActivityItem(
                    icon = Icons.Default.LocationOn,
                    label = "Education",
                    onClick = { navController.navigate("education") }
                )
            }
            item {
                ActivityItem(
                    icon = Icons.Default.Star,
                    label = "Projects",
                    onClick = { navController.navigate("projects") }
                )
            }
            item {
                ActivityItem(
                    icon = Icons.Default.Person,
                    label = "Skills",
                    onClick = { /* Navigate to Skills */ }
                )
            }
            item {
                ActivityItem(
                    icon = Icons.Default.Email,
                    label = "Contact",
                    onClick = { showContactDialog = true }
                )
            }
        }
    }

    if (showContactDialog) {
        AlertDialog(
            onDismissRequest = { showContactDialog = false },
            title = { Text("Contact Me") },
            text = {
                Column {
                    Text("Email: dev.saeyeon@gamil.com")
                    Text("Phone: +821092869157")
                }
            },
            confirmButton = {
                TextButton(onClick = { showContactDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}

@Composable
fun StatisticItem(count: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = count,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ActivityItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = label)
        }
    }
}