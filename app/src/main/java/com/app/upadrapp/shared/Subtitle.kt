package com.app.upadrapp.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Subtitle(text:String, fontSize:Int = 16,  color: Color = Color.White,modifier: Modifier = Modifier,maxLines:Int=999) {
    Text(text = text, color = color, fontSize = fontSize.sp, fontWeight = FontWeight.Normal, modifier = modifier, maxLines =maxLines )
}