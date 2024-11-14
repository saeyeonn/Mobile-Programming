package com.saeyeon.portfolio.ui.screens.profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saeyeon.portfolio.PortfolioApp
import com.saeyeon.portfolio.R
import com.saeyeon.portfolio.ui.components.dialog.ContactDialog
import com.saeyeon.portfolio.ui.components.item.CustomActivityItem
import com.saeyeon.portfolio.ui.theme.PortfolioTheme
import com.saeyeon.portfolio.ui.theme.buttonsColor



@Composable
fun ProfileScreen(navController: NavController) {
    var showContactDialog by remember { mutableStateOf(false) }
    var showAboutSection by remember { mutableStateOf(false) }

    // Material Design layout
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Spacer
            Spacer(modifier = Modifier.weight(1f))

            // Profile Image
            Card(
                modifier = Modifier
                    .size(150.dp)
                    .clickable { showAboutSection = true },
                shape = RoundedCornerShape(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "Profile Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Introduction Text
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF48708F)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Saeyeon Lim",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Hi, I'm a server developer.\n I mainly use Java Spring and recently I'm also studying Kotlin Spring. This is my portfolio app.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Grid Buttons
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.Center
            ) {
                ActivityGrid(navController)
            }

            Spacer(modifier = Modifier.weight(1f))

            // Contact Button
            Button(
                onClick = { showContactDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF48708F)
                )
            ) {
                Text(
                    "Contact",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Contact Dialog
        if (showContactDialog) {
            ContactDialog { showContactDialog = false }
        }
    }
}

@Composable
fun ActivityGrid(navController: NavController) {
    // Grid Layout
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .wrapContentWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Grid Items
        item {
            CustomActivityItem(
                icon = Icons.Default.Star,
                label = "Projects",
                backgroundColor = buttonsColor,
                iconColor = Color.White,
                textColor = Color.Black,
                onClick = { navController.navigate("projects") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Check,
                label = "Awards",
                backgroundColor = buttonsColor,
                iconColor = Color.White,
                textColor = Color.Black,
                onClick = { navController.navigate("awards") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Create,
                label = "Skills",
                backgroundColor = buttonsColor,
                iconColor = Color.White,
                textColor = Color.Black,
                onClick = { navController.navigate("skills") }
            )
        }
        item {
            CustomActivityItem(
                icon = Icons.Default.Favorite,
                label = "Interests",
                backgroundColor = buttonsColor,
                iconColor = Color.White,
                textColor = Color.Black,
                onClick = { navController.navigate("interests") }
            )
        }
    }
}

