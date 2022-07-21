package fr.jaetan.core.enums

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import fr.jaetan.jread.R

enum class FirebaseResponse {
    ToShortPassword,
    ToShortUsername,
    BadEmail,
    Error,
    Success;


    companion object {
        @Composable
        fun toString(value: FirebaseResponse): String {
            return when (value) {
                ToShortPassword -> stringResource(R.string.to_short_password)
                ToShortUsername -> stringResource(R.string.to_short_username)
                BadEmail -> stringResource(R.string.bas_email)
                Error -> stringResource(R.string.auth_error)
                else -> ""
            }
        }
    }
}