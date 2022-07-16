package fr.jaetan.jread.auth

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.jaetan.core.ToggleButtonGroupItem
import fr.jaetan.widgets.ToggleButtonGroup

@Composable
fun AuthScreenContent(
    padding: PaddingValues,
    toggleButtonGroupOptions: List<ToggleButtonGroupItem<ToggleButtonAuthItem>>,
    toggleButtonGroupCurrentId: Int,
    onChangeToggleButton: (Int) -> Unit
) {
    var logInPassword by remember { mutableStateOf("") }
    var logInEmail by remember { mutableStateOf("") }
    var registerPassword by remember { mutableStateOf("") }
    var registerEmail by remember { mutableStateOf("") }
    var registerUsername by remember { mutableStateOf("") }


    Column(
        Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(Modifier.fillMaxWidth())

        Column(
            Modifier
                .padding(horizontal = 20.dp)
                .animateContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ToggleButtonGroup(
                options = toggleButtonGroupOptions,
                selectedOptionId = toggleButtonGroupCurrentId,
                onSelectedOptionChange = onChangeToggleButton
            )

            Spacer(Modifier.height(30.dp))

            if (toggleButtonGroupOptions[toggleButtonGroupCurrentId].type == ToggleButtonAuthItem.LogIn) {
                LogIn(
                    password = logInPassword,
                    email = logInEmail,
                    onPasswordChanged = { value -> logInPassword = value },
                    onEmailChanged = { value -> logInEmail = value }
                )
            } else {
                Register(
                    password = registerPassword,
                    username = registerUsername,
                    email = registerEmail,
                    onPasswordChanged = { value -> registerPassword = value },
                    onUsernameChanged = { value -> registerUsername = value },
                    onEmailChanged = { value -> registerEmail = value }
                )
            }
        }
        
        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = toggleButtonGroupOptions[toggleButtonGroupCurrentId].type.name)
        }
    }
}