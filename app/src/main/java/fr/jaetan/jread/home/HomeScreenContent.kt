package fr.jaetan.jread.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import fr.jaetan.core.controllers.AuthController

@Composable
fun HomeScreenContent(
    padding: PaddingValues,
    goToAuth: () -> Unit
) {
    Column(
        Modifier.padding(padding).fillMaxWidth(),
    ) {
        ElevatedButton(
            onClick = {
                AuthController.signOut()
                goToAuth()
            }
        ) {
            Text(text = "Disconnect")
        }
    }
}