package com.saeyeon.homework3

class Grade(
    private var math: Int,
    private var science: Int,
    private var english: Int){

    fun average(): Int {
        return (math + english + science) / 3
    }
}