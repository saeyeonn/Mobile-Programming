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

class MidP1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val limit = 50
        val primeNumbers = computePrimes(limit)
        Log.d("Midterm", "Prime numbers up to $limit: $primeNumbers")
    }

    private fun computePrimes(limit: Int): Any {
        if (limit < 2) {
            return emptyList<Int>()
        }
        var flag = true
        val primeNumbers = mutableListOf(2)
        for (i in 3..limit) {
            flag = true
            for (j in 2..i-1) {
                if (i % j == 0) {
                    flag = false
                    break
                }
            }
            if (flag) {
                primeNumbers.add(i)
            }
        }
        return primeNumbers
    }
}
