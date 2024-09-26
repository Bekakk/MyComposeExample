package com.example.myapp.di

import com.example.myapp.di.insurance.InsuranceModule
import com.example.myapp.di.loan.LoanModule

object AppModules {
    val modules = listOf(
        LoanModule.modules,
        InsuranceModule.modules
    )


}
