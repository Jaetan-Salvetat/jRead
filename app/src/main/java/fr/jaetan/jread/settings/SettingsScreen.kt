package fr.jaetan.jread.settings

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import fr.jaetan.core.enums.Screen
import fr.jaetan.jread.R
import fr.jaetan.widgets.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavHostController,
    goToAuth: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = stringResource(R.string.settings_title),
                navigationBack = { navController.popBackStack() }
            )
        }
    ) { padding ->
        SettingsScreenContent(
            padding = padding,
            goToAuth = goToAuth,
            goToProfile = { navController.navigate(Screen.Profile.route) }
        )
    }
}