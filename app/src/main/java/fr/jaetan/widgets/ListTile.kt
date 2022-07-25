package fr.jaetan.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import fr.jaetan.jread.R

@Composable
fun ListTile(
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    rippleColor: Color = Color.Gray,
    text: String,
    onPressed: () -> Unit,
    leftIcon: ImageVector,
) {
    RippleEffect(color = rippleColor) {
        Box(
            Modifier
                .fillMaxWidth()
                .clickable { onPressed() }
        ) {
            Row(
                Modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_large)
                    )
            ) {
                Icon(
                    imageVector = leftIcon,
                    contentDescription = text,
                    tint = textColor
                )

                Spacer(Modifier.width(15.dp))

                Text(
                    text = text,
                    color = textColor
                )
            }
        }
    }
}