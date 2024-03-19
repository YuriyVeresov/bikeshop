package ru.veresov.bikeshop.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun BikeShopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) darkPalette else lightPalette
        }

        darkTheme -> darkPalette
        else -> lightPalette
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.backgroundColor.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(
        values = arrayOf(
            LocalBikeShopAppColorScheme provides colorScheme,
            LocalBikeShopBikeShopTypography provides typography,
        ),
        content = content
    )

}

object BikeShopTheme {
    val colorScheme: BikeShopColors
        @Composable
        @ReadOnlyComposable
        get() = LocalBikeShopAppColorScheme.current

    val typography: BikeShopTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalBikeShopBikeShopTypography.current
}