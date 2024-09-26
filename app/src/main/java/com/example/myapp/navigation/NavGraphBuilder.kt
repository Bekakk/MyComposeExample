package com.example.myapp.navigation

import ObserveFeatureLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.myapp.di.insurance.InsuranceModule
import com.example.myapp.di.loan.LoanModule
import com.example.myapp.ui.insurance.screen_1.InsuranceScreen1
import com.example.myapp.ui.insurance.screen_1.InsuranceScreen1ViewModel
import com.example.myapp.ui.insurance.screen_2.InsuranceScreen2
import com.example.myapp.ui.insurance.screen_2.InsuranceScreen2ViewModel
import com.example.myapp.ui.loan.screen_1.LoanScreen1
import com.example.myapp.ui.loan.screen_1.LoanScreen1ViewModel
import com.example.myapp.ui.loan.screen_2.LoanScreen2
import com.example.myapp.ui.loan.screen_2.LoanScreen2ViewModel
import org.koin.androidx.compose.getViewModel


fun NavGraphBuilder.loan(navController: NavHostController) {
    navigation(
        startDestination = LoanScreen.SCREEN1.route,
        route = FeatureGraphs.LOAN
    ) {
        composable(LoanScreen.SCREEN1.route) { navBackStackEntry ->
            val viewModel: LoanScreen1ViewModel = getViewModel()

//            ObserveFeatureLifecycle(
//                navBackStackEntry,
//                LoanModule.modules,
//                navBackStackEntry.destination.route!!
//            )

            LoanScreen1(
                viewModel = viewModel,
                openInsurance = {
                    navController.navigate(FeatureGraphs.INSURANCE) {
                        
                    }
                },
                openScreen2 = {
                    navController.navigate(LoanScreen.SCREEN2.route)

                })
        }

        composable(LoanScreen.SCREEN2.route) { navBackStackEntry ->
            val viewModel: LoanScreen2ViewModel = getViewModel()
//            ObserveFeatureLifecycle(
//                navBackStackEntry,
//                LoanModule.modules,
//                navBackStackEntry.destination.route!!
//            )

            LoanScreen2(
                navController = navController,
                viewModel = viewModel,
            )
        }
    }
}


fun NavGraphBuilder.insurance(navController: NavHostController) {
    navigation(
        startDestination = InsuranceScreen.SCREEN1.route,
        route = FeatureGraphs.INSURANCE
    ) {
        composable(InsuranceScreen.SCREEN1.route) { navBackStackEntry ->
//            ObserveFeatureLifecycle(
//                navBackStackEntry,
//                InsuranceModule.modules,
//                InsuranceScreen.SCREEN1.route
//            )
            val viewModel: InsuranceScreen1ViewModel = getViewModel()
            InsuranceScreen1(navController = navController, viewModel = viewModel)
        }
        composable(InsuranceScreen.SCREEN2.route) { navBackStackEntry ->
            val viewModel: InsuranceScreen2ViewModel = getViewModel()
//            ObserveFeatureLifecycle(
//                navBackStackEntry,
//                InsuranceModule.modules,
//                InsuranceScreen.SCREEN1.route
//            )

            InsuranceScreen2(navController = navController, viewModel = viewModel)
        }
    }
}