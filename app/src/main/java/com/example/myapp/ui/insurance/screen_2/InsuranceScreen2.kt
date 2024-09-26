package com.example.myapp.ui.insurance.screen_2

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun InsuranceScreen2(viewModel: InsuranceScreen2ViewModel, navController: NavHostController) {
    Button(onClick = {
        navController.popBackStack()
    }
    ) {
        Text("Back to Insurance Screen 1")
    }
}