package com.example.myapp.ui.loan.screen_2

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController

@Composable
fun LoanScreen2(
    viewModel: LoanScreen2ViewModel,
    navController: NavHostController
) {
    Button(onClick = { navController.popBackStack() }) {
        Text("Back to Loan Screen 1")
    }

}