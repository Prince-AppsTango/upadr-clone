package com.app.upadrapp.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.upadrapp.ui.theme.DarkBlue

@Composable
fun CustomButton(loading:Boolean = false,enabled:Boolean = true,text: String, width: Int, height: Int = 50,onClick: ()-> Unit) {
    Button(
        enabled = enabled,
        onClick = { onClick()},
        modifier = Modifier
            .background(DarkBlue, shape = RoundedCornerShape(50.dp))
            .width(width.dp)
            .height(height.dp),
        shape = RoundedCornerShape(60.dp),
        colors = ButtonDefaults.buttonColors(DarkBlue)
    ) {
        if(!loading){
           Title(text = text)
        }else{
            CircularProgressIndicator(
                modifier = Modifier.width(35.dp),
                color = Color.White,
                trackColor = Color.Gray,
            )
        }
    }
}
