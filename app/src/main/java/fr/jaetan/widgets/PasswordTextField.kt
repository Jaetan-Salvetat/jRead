package fr.jaetan.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import fr.jaetan.jread.R

@Composable
fun PasswordTextField(
    value: String,
    onValueChanged: (String) -> Unit
) {
    var obscure by remember { mutableStateOf(true) }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChanged,
        label = {
            Text(text = stringResource(R.string.password))
        },
        placeholder = {
            Text(text = stringResource(R.string.password_placeholder))
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation = if(obscure) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = { obscure = !obscure }) {
                Icon(
                    if(obscure)  Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility,
                    contentDescription = null,
                )
            }
        }
    )
}