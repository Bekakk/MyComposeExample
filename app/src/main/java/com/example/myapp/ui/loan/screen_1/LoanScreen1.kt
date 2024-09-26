package com.example.myapp.ui.loan.screen_1

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun LoanScreen1(
    viewModel: LoanScreen1ViewModel,
    openInsurance: () -> Unit,
    openScreen2: () -> Unit
) {
    Column {
        Text("Loan Screen 1")
        Button(onClick = {
            // Navigate within Loan Feature
            openScreen2.invoke()
        }) {
            Text("Go To New Flow")
        }
        Button(onClick = {
            openInsurance.invoke()
        }) {
            Text("Switch to Insurance Feature")
        }
    }

}