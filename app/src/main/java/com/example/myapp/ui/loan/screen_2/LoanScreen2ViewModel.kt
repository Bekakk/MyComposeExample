package com.example.myapp.ui.loan.screen_2

import androidx.lifecycle.ViewModel
import com.example.myapp.FeatureViewModel
import com.example.myapp.ui.loan.LoanRepository

class LoanScreen2ViewModel(private val repository: LoanRepository) : FeatureViewModel() {
    override fun onEnter() {
        println("Entering LoanScreen2ViewModel")
    }

    override fun onExit() {
        println("onExit LoanScreen2ViewModel")

    }

}