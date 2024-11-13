package com.saeyeon.portfolio.ui.components.item

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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