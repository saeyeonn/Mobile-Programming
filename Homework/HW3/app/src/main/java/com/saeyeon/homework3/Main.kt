package com.saeyeon.homework3

import android.util.Log

fun main() {

    val math = 100			// modify these scores for test
    val science = 90			// modify these scores for test
    val english = 80

    val me = Grade(math, science, english)
    Log.d("ITM","my math: $math, my science: $science, my english: $english")
    Log.d("ITM","Average is ${me.average()}")

}