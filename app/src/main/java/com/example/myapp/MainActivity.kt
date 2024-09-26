package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myapp.custom_view.AnimatedNumberInputScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Call MyAppNavHost to handle the navigation logic
//            val navController = rememberNavController()
//            AppNavHostController(navController = navController)

            AnimatedNumberInputScreen()
          //  NumberInputScreen()

        }
    }

    // This method could contain logic that runs once and interacts with navigation
    @Composable
    private fun InitializeApp(navController: NavHostController) {
        // Example: Navigate to a specific screen based on some condition
        println("App initialized")

    }
}


