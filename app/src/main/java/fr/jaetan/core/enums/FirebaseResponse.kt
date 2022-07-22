package fr.jaetan.core.enums

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import fr.jaetan.jread.R

enum class FirebaseResponse {
    ToShortPassword,
    ToShortUsername,
    BadEmail,
    BadEmailOrPassword,
    Error,
    Success,
    None;


    companion object {
        @Composable
        fun toString(value: FirebaseResponse): String {
            return when (value) {
                ToShortPassword -> stringResource(R.string.to_short_password)
                ToShortUsername -> stringResource(R.string.to_short_username)
                BadEmail -> stringResource(R.string.bad_email)
                BadEmailOrPassword -> stringResource(R.string.bad_email_or_password )
                Error -> stringResource(R.string.auth_error)
                else -> ""
            }
        }
    }
}