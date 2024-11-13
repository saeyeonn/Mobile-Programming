package com.saeyeon.portfolio


// ProfileScreen.kt

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

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

@Composable
fun CustomActivityItem(
    icon: ImageVector,
    label: String,
    backgroundColor: Color,
    iconColor: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(backgroundColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(32.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun StatItem(number: String, label: String, sublabel: String) {
    Column {
        Text(
            text = number,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.White
        )
        Text(
            text = sublabel,
            fontSize = 12.sp,
            color = Color.White.copy(alpha = 0.7f)
        )
    }
}