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

class MidP2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Question 2 - Answer
        val input = "I like Android, but Kotlin is umm"
        val lastSize = input.split(" ").last().length
        Log.d("Midterm", "Given String: $input, Length of the last word: $lastSize")
    }

}

