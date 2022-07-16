package fr.jaetan.jread.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import fr.jaetan.core.ToggleButtonGroupItem
import fr.jaetan.jread.R
import fr.jaetan.widgets.ToggleButtonGroup
import fr.jaetan.widgets.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen() {
    val toggleButtonGroupOptions = listOf(
        ToggleButtonGroupItem<ToggleButtonAuthItem>(
            text = stringResource(R.string.login),
            type = ToggleButtonAuthItem.LogIn
        ),
        ToggleButtonGroupItem<ToggleButtonAuthItem>(
            text = stringResource(R.string.register),
            type = ToggleButtonAuthItem.Register
        ),
    )

    var toggleButtonGroupCurrentId by remember { mutableStateOf(0) }

    val onChangeToggleButton = { index: Int ->
        toggleButtonGroupCurrentId = index
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = toggleButtonGroupOptions[toggleButtonGroupCurrentId].text,
                centerTitle = true
            )
        }
    ) { padding ->
        AuthScreenContent(
            padding = padding,
            toggleButtonGroupOptions = toggleButtonGroupOptions,
            toggleButtonGroupCurrentId = toggleButtonGroupCurrentId,
            onChangeToggleButton = onChangeToggleButton
        )
    }
}