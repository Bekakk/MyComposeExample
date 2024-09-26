package com.example.myapp.ui.insurance.screen_1

import androidx.lifecycle.ViewModel
import com.example.myapp.FeatureViewModel
import com.example.myapp.ui.insurance.InsuranceRepository

class InsuranceScreen1ViewModel(private val repository: InsuranceRepository) : FeatureViewModel() {
    // Logic for LoanScreen1
    override fun onEnter() {
        println("Entering InsuranceScreen1ViewModel")
    }

    override fun onExit() {
        println("onExit InsuranceScreen1ViewModel")

    }
}