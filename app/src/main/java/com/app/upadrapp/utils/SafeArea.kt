package com.app.upadrapp.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SafeArea(content : @Composable ()-> Unit) {
    Box(
        modifier = Modifier.fillMaxHeight().fillMaxWidth()
            .background(Color.White) // General padding
            .statusBarsPadding() // Avoids overlap with status bar
            .imePadding() // Avoids overlap with the keyboard if needed
    ) {
       content()
    }
}