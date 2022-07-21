package fr.jaetan.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.jaetan.core.models.ToggleButtonGroupItem
import fr.jaetan.jread.ui.theme.LeftTopBottomShapeLarge
import fr.jaetan.jread.ui.theme.NoShape
import fr.jaetan.jread.ui.theme.RightTopBottomShapeLarge

@Composable
fun <T> ToggleButtonGroup(
    modifier: Modifier = Modifier,
    selectedOptionId: Int,
    options: List<ToggleButtonGroupItem<T>>,
    onSelectedOptionChange: (Int) -> Unit,
) {
    options[selectedOptionId]

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        options.indices.forEach { index ->
            val shape = when (index) {
                0 -> LeftTopBottomShapeLarge
                options.count() - 1 -> RightTopBottomShapeLarge
                else -> NoShape
            }

            Box(
                modifier = Modifier
                    .clip(
                        shape = shape,
                    )
                    .border(1.dp, MaterialTheme.colorScheme.primaryContainer, shape)
                    .clickable {
                        onSelectedOptionChange(index)
                    }
                    .background(
                        if (index == selectedOptionId) {
                            MaterialTheme.colorScheme.primaryContainer.copy(alpha = .8f)
                        } else {
                            Color.Transparent
                        }
                    )
                    .padding(
                        vertical = 12.dp,
                        horizontal = 16.dp,
                    ),
            ) {
                Text(text = options[index].text)
            }
        }
    }
}