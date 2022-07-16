package fr.jaetan.jread.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import fr.jaetan.jread.R
import fr.jaetan.widgets.PasswordTextField

@Composable
fun Register(
    password: String,
    username: String,
    email: String,
    onPasswordChanged: (String) -> Unit,
    onUsernameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
) {
    Column {
        TextField(
            value = email,
            onValueChange = onEmailChanged,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(R.string.email))
            },
            placeholder = {
                Text(text = stringResource(R.string.email_placeholder))
            },
            singleLine = true
        )

        Spacer(Modifier.height(20.dp))

        TextField(
            value = username,
            onValueChange = onUsernameChanged,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(R.string.username))
            },
            placeholder = {
                Text(text = stringResource(R.string.username_placeholder))
            },
            singleLine = true
        )

        Spacer(Modifier.height(20.dp))

        PasswordTextField(
            value = password,
            onValueChanged = onPasswordChanged
        )
    }
}