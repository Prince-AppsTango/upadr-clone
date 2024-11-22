package com.app.upadrapp.shared

import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.app.upadrapp.ui.theme.Black

@Composable
fun DropDownMenuForPrep(mDisplayMenu: Boolean, onDismissRequest: () -> Unit) {
    DropdownMenu(
        expanded = mDisplayMenu,
        onDismissRequest = { onDismissRequest() },
        modifier = Modifier.background(Color.White)
    ) {
         DropdownMenuItem(text = { Text(text = "Edit Procedure", color = Black, fontSize = 16.sp, fontWeight = FontWeight.W600, textAlign = TextAlign.Center)}, onClick = { /*TODO*/ })
         DropdownMenuItem(text = { Text(text = "Cancel Procedure", color = Black, fontSize = 16.sp, fontWeight = FontWeight.W600,textAlign = TextAlign.Center) }, onClick = { /*TODO*/ })
     }
}
