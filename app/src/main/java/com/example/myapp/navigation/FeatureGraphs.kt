package com.example.myapp.navigation

object FeatureGraphs {
    const val LOAN = "LOAN"
    const val INSURANCE = "INSURANCE"
}

sealed class LoanScreen(val route: String) {
    object SCREEN1 : LoanScreen(route = "L_SCREEN1")
    object SCREEN2 : LoanScreen(route = "L_SCREEN2")
}

sealed class InsuranceScreen(val route: String) {
    object SCREEN1 : LoanScreen(route = "I_SCREEN1")
    object SCREEN2 : LoanScreen(route = "I_SCREEN2")
}

object FeatureState {
    // Use a map to track the loaded state of multiple features
    private val featureLoadedStates = mutableMapOf<String, Boolean>()

    fun isFeatureLoaded(featureName: String): Boolean {
        return featureLoadedStates[featureName] ?: false
    }

    fun setFeatureLoaded(featureName: String, loaded: Boolean) {
        featureLoadedStates[featureName] = loaded
    }
}