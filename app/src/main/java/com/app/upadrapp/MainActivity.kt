package com.app.upadrapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.app.upadrapp.navigator.AppNavigation
import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.ui.theme.UpadrTheme
import com.app.upadrapp.utils.SetStatusBarColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContext = applicationContext
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            UpadrTheme {
                SetStatusBarColor(LightCyan, darkIcons = true)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
    companion object {
        // Store application context globally
        private var appContext: Context? = null

        fun getAppContext(): Context {
            return appContext!!
        }
    }
}
