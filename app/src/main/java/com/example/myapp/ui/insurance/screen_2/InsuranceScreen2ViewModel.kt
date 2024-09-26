package com.example.myapp.ui.insurance.screen_2

import androidx.lifecycle.ViewModel
import com.example.myapp.FeatureViewModel
import com.example.myapp.ui.insurance.InsuranceRepository

class InsuranceScreen2ViewModel(private val repository: InsuranceRepository) : FeatureViewModel() {
    override fun onEnter() {
        println("Entering InsuranceScreen2ViewModel")
    }

    override fun onExit() {
        println("onExit InsuranceScreen2ViewModel")

    }
}