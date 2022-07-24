package fr.jaetan.jread

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import fr.jaetan.core.controllers.AuthController
import fr.jaetan.jread.auth.AuthScreen
import fr.jaetan.jread.home.HomeScreen
import fr.jaetan.jread.settings.SettingsScreen

@Composable
fun App() {
    val statusBarColor = MaterialTheme.colorScheme.primaryContainer
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = !darkTheme
        )
    }

    NavigationComponent()
}


@Composable
private fun NavigationComponent() {
    var isConnected by rememberSaveable { mutableStateOf(AuthController.isConnected) }

    if(!isConnected) {
        AuthScreen {
            isConnected = true
        }
        return
    }

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                navController = navController
            )
        }
        composable("settings") {
            SettingsScreen(
                navController = navController
            ) {
                isConnected = false
            }
        }
    }
}