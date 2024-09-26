package com.example.myapp.di.insurance

import com.example.myapp.ui.insurance.InsuranceRepository
import com.example.myapp.ui.insurance.screen_1.InsuranceScreen1ViewModel
import com.example.myapp.ui.insurance.screen_2.InsuranceScreen2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object InsuranceModule {
    val modules = module {
        single { InsuranceRepository() }
        viewModel { InsuranceScreen1ViewModel(get()) }
        viewModel { InsuranceScreen2ViewModel(get()) }
    }
}