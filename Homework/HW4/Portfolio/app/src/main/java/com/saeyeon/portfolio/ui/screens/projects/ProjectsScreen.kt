package com.saeyeon.portfolio.ui.screens.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.saeyeon.portfolio.ui.components.card.ProjectCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectsScreen(navController: NavController) {
    // Material Design layout
    Scaffold(
        topBar = {
            // title styling
            TopAppBar(
                title = {
                    Text(
                        "Projects",
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
        // LazyColumn for scrolling
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Spacer for padding
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            // ProjectCard for each project
            item {
                ProjectCard(
                    title = "STcord",
                    description = "Discord Clone Project with MSA",
                    duration = "In Progress",
                    technologies = listOf("Java", "SpringBoot", "REST API", "MongoDB", "Postgresql", "Redis", "Socket", "AWS")
                )
            }

            item {
                ProjectCard(
                    title = "On-Time",
                    description = "Anti-Tardiness Meeting App",
                    duration = "In Progress",
                    technologies = listOf("Kotlin", "SpringBoot", "Android", "MySQL", "Firebase", "AWS")
                )
            }

            item {
                ProjectCard(
                    title = "GDG on Campus WebApp",
                    description = "An app for gdg on campus member activities and communication",
                    duration = "In Progress",
                    technologies = listOf("Java", "SpringBoot", "Postgresql", "Redis", "GCP", "Github Actions", "Docker")
                )
            }

            item {
                ProjectCard(
                    title = "Portfolio Android App",
                    description = "An app that introduces me",
                    duration = "2024",
                    technologies = listOf("Java", "SpringBoot", "MySQL", "Docker")
                )
            }

            item {
                ProjectCard(
                    title = "QnA Website",
                    description = "GDG Seoultech backend part session materials",
                    duration = "2023",
                    technologies = listOf("Kotlin", "Jetpack Compose", "Material 3")
                )
            }

            item {
                ProjectCard(
                    title = "Pure Plate",
                    description = "A service to search for special restaurants",
                    duration = "2023",
                    technologies = listOf("Python", "Django", "Github Actions")
                )
            }

            item {
                ProjectCard(
                    title = "Portfolio Website",
                    description = "A website that introduces me",
                    duration = "2023",
                    technologies = listOf("HTML5", "CSS3", "Javascript")
                )
            }

            item {
                ProjectCard(
                    title = "Seoultech Total Council App",
                    description = "40th Seoultech Total Council App for students",
                    duration = "2022",
                    technologies = listOf("Java", "SpringBoot", "MySQL", "Redis", "AWS", "Jenkins", "Docker")
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


@Composable
fun Chip(text: String) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val rows = mutableListOf<List<Placeable>>()
        val rowWidths = mutableListOf<Int>()
        val rowHeights = mutableListOf<Int>()

        var currentRow = mutableListOf<Placeable>()
        var currentRowWidth = 0
        var currentRowHeight = 0

        measurables.forEach { measurable ->
            val placeable = measurable.measure(constraints)

            if (currentRowWidth + placeable.width > constraints.maxWidth) {
                rows.add(currentRow)
                rowWidths.add(currentRowWidth)
                rowHeights.add(currentRowHeight)

                currentRow = mutableListOf()
                currentRowWidth = 0
                currentRowHeight = 0
            }

            currentRow.add(placeable)
            currentRowWidth += placeable.width
            currentRowHeight = maxOf(currentRowHeight, placeable.height)
        }

        if (currentRow.isNotEmpty()) {
            rows.add(currentRow)
            rowWidths.add(currentRowWidth)
            rowHeights.add(currentRowHeight)
        }

        val totalHeight = rowHeights.sum()

        layout(constraints.maxWidth, totalHeight) {
            var y = 0
            rows.forEachIndexed { index, row ->
                var x = 0
                row.forEach { placeable ->
                    placeable.place(x, y)
                    x += placeable.width
                }
                y += rowHeights[index]
            }
        }
    }
}