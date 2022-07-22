package fr.jaetan.jread.auth

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import fr.jaetan.core.models.ToggleButtonGroupItem
import fr.jaetan.jread.R
import fr.jaetan.widgets.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    goToHome: () -> Unit
) {
    val toggleButtonGroupOptions = listOf(
        ToggleButtonGroupItem(
            text = stringResource(R.string.login),
            type = ToggleButtonAuthItem.LogIn
        ),
        ToggleButtonGroupItem(
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
            onChangeToggleButton = onChangeToggleButton,
            goToHome = goToHome
        )
    }
}