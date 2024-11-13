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


@Composable
fun ProfileScreen(navController: NavController, onContactClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
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
        }
        Spacer(modifier = Modifier.height(24.dp))
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
                label = "Projects",
                backgroundColor = Color(0xFFFFD700),
                iconColor = Color.White,
                onClick = { navController.navigate("projects") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Star,
                label = "Awards",
                backgroundColor = Color(0xFFFFA500),
                iconColor = Color.White,
                onClick = { navController.navigate("awards") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Person,
                label = "Skills",
                backgroundColor = Color(0xFF4298F5),
                iconColor = Color.White,
                onClick = { navController.navigate("skills") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Star,
                label = "Activities & Interests",
                backgroundColor = Color(0xFF4CAF50),
                iconColor = Color.White,
                onClick = { navController.navigate("activities") }
            )
        }
    }
}


