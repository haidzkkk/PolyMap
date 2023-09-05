package com.example.polymap.ui.home

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class TestViewModel : ViewModel() {

    fun test(): String = "this is test viewModel: ${Random.nextInt()}"
}