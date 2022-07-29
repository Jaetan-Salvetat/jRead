package fr.jaetan.jread.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import fr.jaetan.jread.R
import fr.jaetan.widgets.PasswordTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogIn(
    password: String,
    email: String,
    onPasswordChanged: (String) -> Unit,
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

        PasswordTextField(
            value = password,
            onValueChanged = onPasswordChanged
        )
    }
}