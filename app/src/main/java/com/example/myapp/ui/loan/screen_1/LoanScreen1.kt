package com.example.myapp.ui.loan.screen_1

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun LoanScreen1(
    viewModel: LoanScreen1ViewModel,
    openInsurance: (String?, String?) -> Unit,
    openScreen2: () -> Unit
) {
    Column {
        Button(onClick = {
            // Navigate within Loan Feature
            openScreen2.invoke()
        }) {
            Text("Go to Loan Screen 2")
        }
        Button(onClick = {
            val policyId = "12345"
            val customerName = "John Doe"
            openInsurance.invoke(policyId ,customerName)
        }) {
            Text("Switch to Insurance Feature")
        }
    }

}