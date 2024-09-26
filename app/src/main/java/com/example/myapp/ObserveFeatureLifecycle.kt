import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavBackStackEntry
import com.example.myapp.navigation.FeatureGraphs
import com.example.myapp.navigation.FeatureState
import com.example.myapp.navigation.InsuranceScreen
import com.example.myapp.navigation.LoanScreen
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module


//@Composable
//fun ObserveFeatureLifecycle(
//    navBackStackEntry: NavBackStackEntry,
//    module: Module,
//    screenName: String
//) {
//    val lifecycleOwner = remember { navBackStackEntry.getLifecycle() }
//
//    val observer = remember(navBackStackEntry) {
//        LifecycleEventObserver { _, event ->
//            when (event) {
//                Lifecycle.Event.ON_CREATE -> {
//                    if (!FeatureState.isFeatureLoaded(screenName)) {
//                        loadKoinModules(module)
//                        FeatureState.setFeatureLoaded(screenName, true)
//                        println("$screenName Feature - Screen Created: ${navBackStackEntry.destination.route}")
//                    }
//                }
//
//                Lifecycle.Event.ON_STOP -> {
//                    // Check if we are navigating away from the entire feature
//                    if (navBackStackEntry.destination.route?.startsWith(screenName) == true) {
//                        println("$screenName Feature - Screen Stopped: ${navBackStackEntry.destination.route}")
//                    }
//                }
//
//                Lifecycle.Event.ON_DESTROY -> {
//                    // Call unloadKoinModules only when navigating away from the entire feature
//                    if (navBackStackEntry.destination.route?.startsWith(screenName) == true) {
//                        println("$screenName Feature - Screen Destroyed: ${navBackStackEntry.destination.route}")
//                        unloadKoinModules(module)
//                        FeatureState.setFeatureLoaded(screenName, false) // Reset loaded state
//                    }
//                }
//
//                else -> Unit
//            }
//        }
//    }
//    DisposableEffect(navBackStackEntry) {
//        lifecycleOwner.addObserver(observer)
//        onDispose {
//            lifecycleOwner.removeObserver(observer)
//        }
//    }
//}

@Composable
fun ObserveFeatureLifecycle(navBackStackEntry: NavBackStackEntry, module: Module) {
    // State to track if the module has been loaded

    val lifecycleOwner = remember { navBackStackEntry.getLifecycle() }

    val observer = remember(navBackStackEntry) {
        LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> {
                    // Load the module only if it hasn't been loaded yet

                    loadKoinModules(module)
                    println("Feature ${getFeatureName(navBackStackEntry)} - Screen Created: ${navBackStackEntry.destination.route}")

                }

                Lifecycle.Event.ON_START -> {
                    println("Feature ${getFeatureName(navBackStackEntry)} - Screen Started: ${navBackStackEntry.destination.route}")
                }

                Lifecycle.Event.ON_RESUME -> {
                    println("Feature ${getFeatureName(navBackStackEntry)} - Screen Resumed: ${navBackStackEntry.destination.route}")
                }

                Lifecycle.Event.ON_PAUSE -> {
                    println("Feature ${getFeatureName(navBackStackEntry)} - Screen Paused: ${navBackStackEntry.destination.route}")
                }

                Lifecycle.Event.ON_STOP -> {
                    println("Feature ${getFeatureName(navBackStackEntry)} - Screen Stopped: ${navBackStackEntry.destination.route}")
                }

                Lifecycle.Event.ON_DESTROY -> {
                    println("Feature ${getFeatureName(navBackStackEntry)} - Screen Destroyed: ${navBackStackEntry.destination.route}")
                    unloadKoinModules(module)
                }

                else -> Unit
            }
        }
    }

    DisposableEffect(navBackStackEntry) {
        lifecycleOwner.addObserver(observer)

        onDispose {
            lifecycleOwner.removeObserver(observer)
        }
    }
}

private fun getFeatureName(navBackStackEntry: NavBackStackEntry): String {
    return when (navBackStackEntry.destination.route) {
        LoanScreen.SCREEN1.route, LoanScreen.SCREEN1.route -> FeatureGraphs.LOAN
        InsuranceScreen.SCREEN1.route, InsuranceScreen.SCREEN2.route -> FeatureGraphs.INSURANCE
        else -> "Unknown Feature"
    }
}
