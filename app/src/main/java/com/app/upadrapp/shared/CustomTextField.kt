package com.app.upadrapp.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.upadrapp.ui.theme.BorderColor
import com.app.upadrapp.ui.theme.TextFieldTColor

@Composable
fun CustomTextField(text: String, value: String, onChangeValue: (it: String) -> Unit) {
    OutlinedTextField(
        value = value,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BorderColor,
            unfocusedBorderColor = BorderColor,
            focusedTextColor = BorderColor
        ),
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(60.dp),
        onValueChange = {
            onChangeValue(it)
        },
        label = {
            Text(text = text, color = TextFieldTColor, fontSize = 14.sp)
        },
        placeholder = {
            Text(text = text, fontSize = 14.sp)
        }
    )
}