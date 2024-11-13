package com.saeyeon.portfolio.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saeyeon.portfolio.ui.components.item.CustomActivityItem
import com.saeyeon.portfolio.ui.components.item.StatItem

@Composable
fun ProfileScreen(navController: NavController, onContactClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        // Profile Image and Follow Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Image
            Card(
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        tint = Color.DarkGray
                    )
                }
            }

            // Follow Button
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Follow")
            }
        }

        // Stats Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatItem("6", "New Projects", "this month")
            StatItem("4", "New Skills", "this week")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Activity Grid
        ActivityGrid(navController)
    }
}

@Composable
fun ActivityGrid(navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        item {
            CustomActivityItem(
                icon = Icons.Default.Star,
                label = "Curriculum Vitae",
                backgroundColor = Color(0xFFFFD700),
                iconColor = Color.White,
                onClick = { navController.navigate("curriculum") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Star,
                label = "Awards & Achievements",
                backgroundColor = Color(0xFFFFA500),
                iconColor = Color.White,
                onClick = { navController.navigate("awards") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Person,
                label = "Skill Set",
                backgroundColor = Color(0xFF4298F5),
                iconColor = Color.White,
                onClick = { navController.navigate("skills") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Star,
                label = "Other Activities & Interests",
                backgroundColor = Color(0xFF4CAF50),
                iconColor = Color.White,
                onClick = { navController.navigate("activities") }
            )
        }
    }
}


