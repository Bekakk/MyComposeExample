package com.example.myapp

import androidx.lifecycle.ViewModel

abstract class FeatureViewModel : ViewModel() {
    abstract fun onEnter()

    abstract  fun onExit()
}