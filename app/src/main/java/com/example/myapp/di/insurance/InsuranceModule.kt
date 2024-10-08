package com.example.myapp.di.insurance

import com.example.myapp.di.loan.LOANS_GLOBAL_SCOPE
import com.example.myapp.ui.insurance.InsuranceRepository
import com.example.myapp.ui.insurance.screen_1.InsuranceScreen1ViewModel
import com.example.myapp.ui.insurance.screen_2.InsuranceScreen2ViewModel
import com.example.myapp.ui.loan.LoanRepository
import com.example.myapp.ui.loan.screen_1.LoanScreen1ViewModel
import com.example.myapp.ui.loan.screen_2.LoanScreen2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

//object InsuranceModule {
//    val modules = module {
//        single { InsuranceRepository() }
//        viewModel { InsuranceScreen1ViewModel(get()) }
//        viewModel { InsuranceScreen2ViewModel(get()) }
//    }
//}

val  InsuranceModuleScope = module {
    scope(named(INSTALLMENT_GLOBAL_SCOPE)) {
        viewModel { InsuranceScreen1ViewModel(get()) }
        viewModel { InsuranceScreen2ViewModel(get()) }
        scoped { InsuranceRepository() }

    }
}
const val INSTALLMENT_GLOBAL_SCOPE= "INSTALLMENT_GLOBAL_SCOPE"