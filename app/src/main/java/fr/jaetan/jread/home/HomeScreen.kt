package fr.jaetan.jread.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import fr.jaetan.jread.R
import fr.jaetan.widgets.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    goToAuth: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = stringResource(R.string.home_title)
            )
        }
    ) { padding ->
        HomeScreenContent(
            padding = padding,
            goToAuth = goToAuth
        )
    }
}