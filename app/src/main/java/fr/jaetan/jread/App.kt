package fr.jaetan.jread

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.auth.FirebaseAuth
import fr.jaetan.core.controllers.AuthController
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

    Navigation()
}


@Composable
private fun Navigation() {
    if(AuthController.isConnected) {
        AlertDialog(
            title = { Text(text = FirebaseAuth.getInstance().currentUser?.displayName ?: "") },
            text = { Text(text = "You're connected") },
            dismissButton = {
                TextButton(
                    onClick = {
                        AuthController.signOut()
                    }
                ) {
                    Text(text = "Sign out")
                }
            },
            confirmButton = {},
            onDismissRequest = { /*TODO*/ }
        )
    }

    AuthScreen()
}