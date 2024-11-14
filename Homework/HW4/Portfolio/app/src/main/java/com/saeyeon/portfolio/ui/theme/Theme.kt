package com.saeyeon.portfolio.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


private val md_theme_light_primary = Color(0xFFFFFFFF)
private val md_theme_light_onPrimary = Color(0xFF55808B)
private val md_theme_light_secondary = Color(0xFFF3E5F5)
private val md_theme_light_onSecondary = Color(0xFF9C27B0)
private val md_theme_light_background = Color(0xFFFFFFFF)
private val md_theme_light_onBackground = Color(0xFF000000)
private val md_theme_light_surface = Color(0xFFFFFFFF)
private val md_theme_light_onSurface = Color(0xFF00BCD4)
private val md_theme_light_primaryContainer = Color(0xFFF5F5F5)

private val md_theme_dark_primary = Color(0xFFE1F5FE)
private val md_theme_dark_onPrimary = Color(0xFF0288D1)
private val md_theme_dark_secondary = Color(0xFFE0F7FA)
private val md_theme_dark_onSecondary = Color(0xFF00BCD4)
private val md_theme_dark_background = Color(0xFFF8F9FA)
private val md_theme_dark_onBackground = Color(0xFF000000)
private val md_theme_dark_surface = Color(0xFFFFFFFF)
private val md_theme_dark_onSurface = Color(0xFF000000)
private val md_theme_dark_primaryContainer = Color(0xFFF5F5F5)

val buttonsColor = Color(0xFF48708F)


private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface
)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface
)

@Composable
fun PortfolioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}