package fr.jaetan.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TopAppBar(
    backButton: Boolean = false,
    centerTitle: Boolean = false,
    background: Color = MaterialTheme.colorScheme.background,
    title: String,
) {
    if(centerTitle) {
        CenterAlignedTopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                if(backButton){
                    IconButton(onClick = { /*TODO*/ }) {
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
            navigationIcon = {
                if(backButton){
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            }
        )
    }
}