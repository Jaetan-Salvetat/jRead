package fr.jaetan.jread.profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import fr.jaetan.jread.R
import fr.jaetan.widgets.TopAppBar

@Composable
fun ProfileAppBar(
    edit: Boolean,
    onEditPressed: () -> Unit,
    onSavePressed: () -> Unit,
    onBackNavigationPressed: () -> Unit,
) {
    TopAppBar(
        title = stringResource(R.string.profile_title),
        navigationBack = onBackNavigationPressed,
        actions = {
            IconButton(
                onClick = if(edit) onSavePressed else onEditPressed
            ) {
                if (edit) {
                    Icon(
                        imageVector = Icons.Rounded.Done,
                        contentDescription = null
                    )
                } else {
                    Icon(
                        imageVector = Icons.Rounded.Edit,
                        contentDescription = null
                    )
                }
            }
        }
    )
}