package com.example.myapp.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
sealed class FeatureGraphs {

    @Serializable
    sealed class LOAN : FeatureGraphs() {
        @Serializable
        data object Screen1 : LOAN()

        @Serializable
        data object Screen2 : LOAN()
    }

    @Serializable
    sealed class INSURANCE : FeatureGraphs() {
        @Serializable
        data class Screen1(
            val policyId: String,
            val customerName: String
        ) : INSURANCE() {
            fun route(): String {
                // Serialize the object to a JSON string for the route
                val jsonString = Json.encodeToString(this)
                return "${this::class.java.name}/$jsonString"
            }
        }

        @Serializable
        data object Screen2 : INSURANCE()
    }
}






