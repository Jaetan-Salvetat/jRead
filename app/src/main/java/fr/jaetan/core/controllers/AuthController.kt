package fr.jaetan.core.controllers

import com.google.firebase.auth.FirebaseAuth
import fr.jaetan.core.enums.FirebaseResponse

class AuthController {
    companion object {
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        val isConnected = auth.currentUser != null

        fun signIn(email: String, password: String) {
            auth.signInWithEmailAndPassword(email ,password)
        }

        fun register(email: String, password: String, username: String, callback: (msg: FirebaseResponse) -> Unit) {
            val isUserInputsValid = validateUserInputs(email, password, username)

            if (isUserInputsValid != FirebaseResponse.Success) {
                callback(isUserInputsValid)
            }

            try {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            callback(FirebaseResponse.Success)
                        } else {
                            callback(FirebaseResponse.Error)
                        }
                    }
            }catch (e: Exception) {
                callback(FirebaseResponse.Error)
            }
        }

        fun signOut() = auth.signOut()



        private fun validateUserInputs(email: String, password: String, username: String): FirebaseResponse {
            val emailRegex = Regex("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+")

            if (password.length < 6) {
                return FirebaseResponse.ToShortPassword
            } else if (username.length < 4) {
                return FirebaseResponse.ToShortUsername
            } else if (emailRegex.matches(email)) {
                return FirebaseResponse.BadEmail
            }

            return FirebaseResponse.Success
        }
    }
}