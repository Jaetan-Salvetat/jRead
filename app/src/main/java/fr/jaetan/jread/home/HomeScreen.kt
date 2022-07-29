package fr.jaetan.jread.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import fr.jaetan.core.enums.Screen
import fr.jaetan.jread.R
import fr.jaetan.widgets.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = stringResource(R.string.home_title)
            ) {
                IconButton(onClick = { navController.navigate(Screen.Settings.route) }) {
                    Icon(
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = null
                    )
                }
            }
        }
    ) { padding ->
        HomeScreenContent(
            padding = padding
        )
    }
}