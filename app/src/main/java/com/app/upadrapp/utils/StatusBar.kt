package com.app.upadrapp.utils

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun SetStatusBarColor(color: Color, darkIcons: Boolean = false) {
    val context = LocalContext.current
    val window = (context as? ComponentActivity)?.window
    val view = LocalView.current
    SideEffect {
        window?.statusBarColor = color.toArgb()
        window?.let {
            val insetsController = WindowCompat.getInsetsController(it, view)
            insetsController?.isAppearanceLightStatusBars = darkIcons
        }
    }
}
