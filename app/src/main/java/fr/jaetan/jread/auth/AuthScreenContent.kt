package fr.jaetan.jread.auth

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.jaetan.core.controllers.AuthController
import fr.jaetan.core.enums.FirebaseResponse
import fr.jaetan.core.models.ToggleButtonGroupItem
import fr.jaetan.widgets.ErrorContainer
import fr.jaetan.widgets.ToggleButtonGroup

@Composable
fun AuthScreenContent(
    padding: PaddingValues,
    toggleButtonGroupOptions: List<ToggleButtonGroupItem<ToggleButtonAuthItem>>,
    toggleButtonGroupCurrentId: Int,
    onChangeToggleButton: (Int) -> Unit
) {
    var errorStatus by remember { mutableStateOf(FirebaseResponse.None) }
    var loading by remember { mutableStateOf(false) }
    var logInPassword by remember { mutableStateOf("") }
    var logInEmail by remember { mutableStateOf("") }
    var registerPassword by remember { mutableStateOf("") }
    var registerEmail by remember { mutableStateOf("") }
    var registerUsername by remember { mutableStateOf("") }

    val auth = {
        loading = true

        if (toggleButtonGroupOptions[toggleButtonGroupCurrentId].type == ToggleButtonAuthItem.LogIn) {
            AuthController.signIn(logInEmail, logInPassword) { res ->
                errorStatus = res
                loading = false
            }
        } else {
            AuthController.register(registerEmail, registerPassword, registerUsername) { res ->
                errorStatus = res
                loading = false
            }
        }
    }


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
                onSelectedOptionChange = {
                    onChangeToggleButton(it)
                    errorStatus = FirebaseResponse.None
                }
            )


            Spacer(Modifier.height(15.dp))
            ErrorContainer(FirebaseResponse.toString(errorStatus))
            Spacer(Modifier.height(15.dp))


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
            onClick = auth
        ) {
            if (loading) {
                CircularProgressIndicator(Modifier.size(25.dp))
            } else {
                Text(text = toggleButtonGroupOptions[toggleButtonGroupCurrentId].text)
            }
        }
    }
}