package com.app.upadrapp.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CustomTextField(text: String, value: String, onChangeValue: (it: String) -> Unit) {
    OutlinedTextField(
        value = value,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        onValueChange = {
            onChangeValue(it)
        },
        label = {
            Text(text = text)
        })
}