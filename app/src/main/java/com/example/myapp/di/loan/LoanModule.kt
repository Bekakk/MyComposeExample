package com.example.myapp.di.loan

import com.example.myapp.ui.loan.LoanRepository
import com.example.myapp.ui.loan.screen_1.LoanScreen1ViewModel
import com.example.myapp.ui.loan.screen_2.LoanScreen2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object LoanModule {
    val modules = module {
        single { LoanRepository() }
        viewModel { LoanScreen1ViewModel(get()) }
        viewModel { LoanScreen2ViewModel(get()) }
    }
}