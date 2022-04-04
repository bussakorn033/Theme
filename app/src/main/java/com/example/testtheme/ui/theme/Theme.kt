package com.example.testtheme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary= LightPrimary,
    primaryVariant= LightPrimaryVariant,
    onPrimary= LightOnPrimary,
    secondary= LightSecondary,
    secondaryVariant= LightSecondaryVariant,
    onSecondary= LightOnSecondary,
    background= LightBackground,
    onBackground= LightOnBackground,
    surface= LightSurface,
    onSurface= LightOnSurface,
    error= LightError,
    onError= LightOnError,
)

private val DarkColorPalette = darkColors(
    primary= DarkPrimary,
    primaryVariant= DarkPrimaryVariant,
    onPrimary= DarkOnPrimary,
    secondary= DarkSecondary,
    secondaryVariant= DarkSecondaryVariant,
    onSecondary= DarkOnSecondary,
    background= DarkBackground,
    onBackground= DarkOnBackground,
    surface= DarkSurface,
    onSurface= DarkOnSurface,
    error= DarkError,
    onError= DarkOnError,
)

@Composable
fun TestTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}