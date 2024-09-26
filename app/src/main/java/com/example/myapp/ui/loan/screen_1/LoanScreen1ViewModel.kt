package com.example.myapp.ui.loan.screen_1

import androidx.lifecycle.ViewModel
import com.example.myapp.FeatureViewModel
import com.example.myapp.ui.loan.LoanRepository

class LoanScreen1ViewModel(private val repository: LoanRepository) : FeatureViewModel() {
    // Logic for LoanScreen1
    override fun onEnter() {
        println("Entering LoanScreen1ViewModel")
    }

    override fun onExit() {
        println("onExit LoanScreen1ViewModel")

    }

}