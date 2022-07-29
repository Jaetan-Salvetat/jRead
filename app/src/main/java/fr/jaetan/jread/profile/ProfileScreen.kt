package fr.jaetan.jread.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import fr.jaetan.jread.R
import fr.jaetan.widgets.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    var edit by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            ProfileAppBar(
                edit = edit,
                onEditPressed = { edit = true },
                onSavePressed = { edit = false },
                onBackNavigationPressed = {
                    if (edit) {
                        edit = false
                    } else {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) { padding ->
        if (edit) {
            ProfileScreenContentEditing(padding)
        } else {
            ProfileScreenContentDisplaying(padding)
        }
    }
}