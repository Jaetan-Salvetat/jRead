package fr.jaetan.jread.settings

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.PowerSettingsNew
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import fr.jaetan.jread.R
import fr.jaetan.widgets.ListTile

@Composable
fun SettingsScreenContent(
    padding: PaddingValues,
    goToAuth: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(padding)
            .verticalScroll(rememberScrollState())
    ) {

        ListTile(
            text = stringResource(R.string.my_profile),
            leftIcon = Icons.Rounded.AccountCircle,
            onPressed = {},
        )

        Divider(
            Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
            color = MaterialTheme.colorScheme.inverseOnSurface.copy(alpha = .6f)
        )

        ListTile(
            text = stringResource(R.string.disconnect),
            leftIcon = Icons.Rounded.PowerSettingsNew,
            onPressed = goToAuth,
            textColor = Color.Red,
            rippleColor = Color.Red
        )
    }
}