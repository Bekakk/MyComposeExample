package com.example.myapp.ui.insurance.screen_1

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myapp.navigation.FeatureGraphs

@Composable
fun InsuranceScreen1(
    viewModel: InsuranceScreen1ViewModel, navController: NavHostController,
    openScreen2: () -> Unit,
    insuranceDetails: FeatureGraphs.INSURANCE.Screen1?
) {

    Column {

        insuranceDetails.let {
            Text(text = "Policy ID: ${it?.policyId}")
            Text(text = "Customer Name: ${it?.customerName}")
        }


        Button(onClick = {
            openScreen2.invoke()
        }) {
            Text("Go to Insurance Screen 2")
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Return to loan feature")
        }
    }
}