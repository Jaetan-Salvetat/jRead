package fr.jaetan.jread

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import fr.jaetan.jread.auth.AuthScreen

@Composable
fun App() {
    val statusBarColor = MaterialTheme.colorScheme.background
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = !darkTheme
        )
    }


    AuthScreen()
}