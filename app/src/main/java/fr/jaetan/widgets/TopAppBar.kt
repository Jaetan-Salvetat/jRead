package fr.jaetan.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TopAppBar(
    navigationBack: (() -> Unit)? = null,
    centerTitle: Boolean = false,
    background: Color = MaterialTheme.colorScheme.background,
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
) {
    if(centerTitle) {
        CenterAlignedTopAppBar(
            title = { Text(text = title) },
            actions = actions,
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = background
            ),
            navigationIcon = {
                if(navigationBack != null){
                    IconButton(onClick = navigationBack) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            }
        )
    } else {
        SmallTopAppBar(
            title = { Text(text = title) },
            actions = actions,
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = background
            ),
            navigationIcon = {
                if(navigationBack != null){
                    IconButton(onClick = navigationBack) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            },
        )
    }
}