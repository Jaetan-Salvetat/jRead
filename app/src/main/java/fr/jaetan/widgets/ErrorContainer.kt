package fr.jaetan.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import fr.jaetan.jread.R
import fr.jaetan.jread.ui.theme.SmallShape

@Composable
fun ErrorContainer(error: String) {
    if (error.isNotEmpty()) {
        Column(
            Modifier
                .fillMaxWidth()
                .clip(SmallShape)
                .background(MaterialTheme.colorScheme.errorContainer.copy(alpha = .4f), SmallShape)
                .border(1.dp, MaterialTheme.colorScheme.errorContainer, SmallShape)
                .padding(
                    vertical = dimensionResource(R.dimen.padding_large),
                    horizontal = dimensionResource(R.dimen.padding_medium)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = error)
        }
    }
}