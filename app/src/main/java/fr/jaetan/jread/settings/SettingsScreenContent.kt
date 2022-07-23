package fr.jaetan.jread.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import fr.jaetan.jread.R

@Composable
fun SettingsScreenContent(
    padding: PaddingValues,
    goToAuth: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(padding)
            .padding(horizontal = dimensionResource(R.dimen.padding_medium))
    ) {
        TextButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = goToAuth,
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.Red
            )
        ) {
            Text(text = "Déconnexion")
        }
    }
}