package com.saeyeon.portfolio.ui.screens.education

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saeyeon.portfolio.ui.components.card.EducationCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Education") },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            EducationCard(
                schoolName = "NORTHUMBRIA UNIVERSITY",
                degree = "Bachelor of ITMB",
                year = "2023 - 2026"
            )

            EducationCard(
                schoolName = "SEOUL NATIONAL UNIVERSITY OF SCIENCE AND TECHNOLOGY",
                degree = "Bachelor of ITM",
                year = "2021 - 2026"
            )

            EducationCard(
                schoolName = "EWHA GIRLS' HIGH SCHOOL",
                year = "2017 - 2020"
            )

            EducationCard(
                schoolName = "YEOMCHANG MIDDLE SCHOOL",
                year = "2014 - 2017"
            )

            EducationCard(
                schoolName = "YEOMDONG ELEMENTARY SCHOOL",
                year = "2008 - 2014"
            )
        }
    }
}

