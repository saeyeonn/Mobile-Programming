package com.saeyeon.midterm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saeyeon.midterm.ui.theme.MidtermTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Question 3 - Answer
        val row = Random.nextInt(1,6)
        val col = Random.nextInt(1,6)
        val min = if (row < col) row - 1 else col - 1

        val list = List(row) { List(col) { Random.nextInt(1, 101) } }
        Log.d("Midterm", "Row: $row, Col: $col")
        Log.d("Midterm", "2D List: $list")
        Log.d("Midterm", "Index of Column that contains the minimum value: $min")
    }

}

