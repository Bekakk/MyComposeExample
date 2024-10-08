package com.example.myapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.myapp.ui.insurance.screen_1.InsuranceScreen1
import com.example.myapp.ui.insurance.screen_1.InsuranceScreen1ViewModel
import com.example.myapp.ui.insurance.screen_2.InsuranceScreen2
import com.example.myapp.ui.insurance.screen_2.InsuranceScreen2ViewModel
import com.example.myapp.ui.loan.screen_1.LoanScreen1
import com.example.myapp.ui.loan.screen_1.LoanScreen1ViewModel
import com.example.myapp.ui.loan.screen_2.LoanScreen2
import com.example.myapp.ui.loan.screen_2.LoanScreen2ViewModel
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.loan(navController: NavHostController) {
    navigation(
        startDestination = FeatureGraphs.LOAN.Screen1::class.java.name,
        route = FeatureGraphs.LOAN::class.java.name
    ) {
        composable(
            route = FeatureGraphs.LOAN.Screen1::class.java.name
        ) {
            val viewModel: LoanScreen1ViewModel = koinViewModel()
            LoanScreen1(
                viewModel = viewModel,
                openInsurance = { policyId, customerName ->
                    val screen1 = FeatureGraphs.INSURANCE.Screen1(
                        policyId = policyId!!,
                        customerName = customerName!!
                    )
                    navController.navigate(screen1.route())
                },
                openScreen2 = {
                    navController.navigate(FeatureGraphs.LOAN.Screen2::class.java.name)
                }
            )
        }

        composable(
            route = FeatureGraphs.LOAN.Screen2::class.java.name
        ) {
            val viewModel: LoanScreen2ViewModel = koinViewModel()
            LoanScreen2(
                navController = navController,
                viewModel = viewModel,
            )
        }
    }
}

fun NavGraphBuilder.insurance(navController: NavHostController) {
    navigation(
        startDestination = "${FeatureGraphs.INSURANCE.Screen1::class.java.name}/{insuranceDetails}",
        route = FeatureGraphs.INSURANCE::class.java.name
    ) {
        composable(
            route = "${FeatureGraphs.INSURANCE.Screen1::class.java.name}/{insuranceDetails}"
        ) { backStackEntry ->
            // Retrieve the JSON string from the back stack entry
            val jsonString = backStackEntry.arguments?.getString("insuranceDetails")
            val insuranceDetails =
                jsonString?.let { Json.decodeFromString<FeatureGraphs.INSURANCE.Screen1>(it) }

            val viewModel: InsuranceScreen1ViewModel = koinViewModel()
            InsuranceScreen1(
                navController = navController,
                viewModel = viewModel,
                insuranceDetails = insuranceDetails
            )
        }

        composable(
            route = FeatureGraphs.INSURANCE.Screen2::class.java.name
        ) {
            val viewModel: InsuranceScreen2ViewModel = koinViewModel()
            InsuranceScreen2(navController = navController, viewModel = viewModel)
        }
    }
}
