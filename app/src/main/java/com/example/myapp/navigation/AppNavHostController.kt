package com.example.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHostController(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = FeatureGraphs.LOAN::class.java.name
    ) {
        loan(navController)
        insurance(navController)
    }
}