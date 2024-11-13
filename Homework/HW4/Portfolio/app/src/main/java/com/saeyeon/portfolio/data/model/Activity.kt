package com.saeyeon.portfolio.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Activity(
    val title: String,
    val description: String,
    val period: String,
    val icon: ImageVector
)

