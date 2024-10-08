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
import com.example.myapp.di.insurance.INSTALLMENT_GLOBAL_SCOPE
import com.example.myapp.di.loan.LOANS_GLOBAL_SCOPE
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin
import org.koin.core.qualifier.named

fun NavGraphBuilder.loan(navController: NavHostController) {
    navigation(
        startDestination = FeatureGraphs.LOAN.Screen1::class.java.name,
        route = FeatureGraphs.LOAN::class.java.name
    ) {
        composable(
            route = FeatureGraphs.LOAN.Screen1::class.java.name
        ) {

            //loan screen scope
            val scope = getKoin().getOrCreateScope(LOANS_GLOBAL_SCOPE, named(LOANS_GLOBAL_SCOPE))
            val viewModel: LoanScreen1ViewModel = koinViewModel(scope = scope)

            LoanScreen1(
                viewModel = viewModel,
                openInsurance = { policyId, customerName ->
                   // scope.close()
                    val insuranceScreen = FeatureGraphs.INSURANCE.Screen1(
                        policyId = policyId!!,
                        customerName = customerName!!
                    )
                    navController.navigate(insuranceScreen.route())
                },
                openScreen2 = {
                    navController.navigate(FeatureGraphs.LOAN.Screen2::class.java.name)
                }
            )
        }

        composable(
            route = FeatureGraphs.LOAN.Screen2::class.java.name
        ) {

            //duplicate code
            val scope = getKoin().getOrCreateScope(LOANS_GLOBAL_SCOPE, named(LOANS_GLOBAL_SCOPE))
            val viewModel: LoanScreen2ViewModel = koinViewModel(scope = scope)
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


            // installment screen_1 scope
            val scope = getKoin().getOrCreateScope(INSTALLMENT_GLOBAL_SCOPE, named(INSTALLMENT_GLOBAL_SCOPE))
            val viewModel: InsuranceScreen1ViewModel = koinViewModel(scope = scope)

            InsuranceScreen1(
                navController = navController,
                viewModel = viewModel,
                insuranceDetails = insuranceDetails,
                openScreen2 = {
                  //  scope.close()
                    navController.navigate(FeatureGraphs.INSURANCE.Screen2::class.java.name)
                }
            )
        }

        composable(
            route = FeatureGraphs.INSURANCE.Screen2::class.java.name
        ) {
            //duplicate code
            val scope = getKoin().getOrCreateScope(INSTALLMENT_GLOBAL_SCOPE, named(INSTALLMENT_GLOBAL_SCOPE))
            val viewModel: InsuranceScreen2ViewModel = koinViewModel(scope = scope)
            InsuranceScreen2(navController = navController, viewModel = viewModel)
        }
    }
}
