package fr.jaetan.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

@Composable
fun RippleEffect(
    color: Color,
    content: @Composable () -> Unit
) {
    val ripple = object: RippleTheme {
        @Composable
        override fun defaultColor() = color

        @Composable
        override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
            color,
            lightTheme = !isSystemInDarkTheme()
        )
    }

    CompositionLocalProvider(LocalRippleTheme provides ripple) {
        content()
    }
}