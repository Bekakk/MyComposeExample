//package com.example.myapp
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.material3.Button
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.lifecycle.Lifecycle
//import androidx.lifecycle.LifecycleEventObserver
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavBackStackEntry
//import androidx.navigation.NavController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.navigation
//import androidx.navigation.compose.rememberNavController
//import com.example.myapp.ui.SampleViewModel
//import com.example.myapp.ui.theme.NestedNavigationGraphsGuideTheme
//
//class MainActivity2 : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            NestedNavigationGraphsGuideTheme  {
//             //   val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = "auth") {
//                    composable("about") {
//
//                    }
//                    navigation(
//                        startDestination = "login",
//                        route = "auth"
//                    ) {
//                        composable("login") {
//                            val viewModel = it.sharedViewModel<SampleViewModel>(navController)
//
//                            val navGraphRoute = it.destination.parent?.route!!
//                            val parentEntry = remember(this) {
//                                navController.getBackStackEntry(navGraphRoute)
//                            }
//
//                            parentEntry.LifecycleObserver()
//
//                            Button (onClick = {
//                                navController.navigate("calendar") {
//                                    popUpTo("auth") {
//                                        inclusive = true
//                                    }
//                                }
//                            }) {
//
//                            }
//                        }
//                        composable("register") {
//                            val viewModel = it.sharedViewModel<SampleViewModel>(navController)
//                        }
//                        composable("forgot_password") {
//                            val viewModel = it.sharedViewModel<SampleViewModel>(navController)
//                        }
//                    }
//                    navigation(
//                        startDestination = "calendar_overview",
//                        route = "calendar"
//                    ) {
//                        composable("calendar_overview") {
//
//                        }
//                        composable("calendar_entry") {
//
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
//    val navGraphRoute = destination.parent?.route ?: return viewModel()
//    val parentEntry = remember(this) {
//        navController.getBackStackEntry(navGraphRoute)
//    }
//    return viewModel(parentEntry)
//}
//
//fun NavBackStackEntry.LifecycleObserver() {
//    // Get the Lifecycle of this BackStackEntry
//    val lifecycle = this.getLifecycle()
//
//    // Create a LifecycleEventObserver
//    val observer = LifecycleEventObserver { source, event ->
//        when (event) {
//            Lifecycle.Event.ON_CREATE -> {
//                // Handle ON_CREATE event
//                println("Screen Created")
//            }
//            Lifecycle.Event.ON_START -> {
//                // Handle ON_START event
//                println("Screen Started")
//            }
//            Lifecycle.Event.ON_RESUME -> {
//                // Handle ON_RESUME event
//                println("Screen Resumed")
//            }
//            Lifecycle.Event.ON_PAUSE -> {
//                // Handle ON_PAUSE event
//                println("Screen Paused")
//            }
//            Lifecycle.Event.ON_STOP -> {
//                // Handle ON_STOP event
//                println("Screen Stopped")
//            }
//            Lifecycle.Event.ON_DESTROY -> {
//                // Handle ON_DESTROY event
//                println("Screen Destroyed")
//            }
//            else -> Unit
//        }
//    }
//
//    // Add the observer to the lifecycle
//    lifecycle.addObserver(observer)
//
//    // Remove the observer when necessary (optional cleanup)
//    lifecycle.addObserver(LifecycleEventObserver { _, event ->
//        if (event == Lifecycle.Event.ON_DESTROY) {
//            lifecycle.removeObserver(observer)
//        }
//    })
//}
