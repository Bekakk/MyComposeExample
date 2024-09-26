package com.example.myapp.ui.insurance.screen_1

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myapp.navigation.InsuranceScreen

@Composable
fun InsuranceScreen1(viewModel: InsuranceScreen1ViewModel, navController: NavHostController) {
    Column {
        Text("Go to Insurance Screen 2")
        Button(onClick = {
            navController.navigate(InsuranceScreen.SCREEN2.route) {}
        }) {
            Text("Go To New Flow")
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Return to loan feature")
        }
    }
}