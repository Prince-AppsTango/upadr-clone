package com.app.upadrapp.shared


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.upadrapp.ui.theme.Black


@Composable
fun ButtonWithIcon(text:String,fontSize:Int=15,onClick:()->Unit) {
  Card(modifier = Modifier
      .fillMaxWidth()
      .background(Color.White)
      .clickable { onClick() }
      .height(50.dp), elevation = CardDefaults.cardElevation(5.dp)) {
      Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
          .fillMaxWidth()
          .background(
              Color.White
          ).padding(10.dp,0.dp)
          .height(50.dp)) {
          Title(text = text, color = Black, fontSize = fontSize)
          Icon(
              Icons.Filled.KeyboardArrowRight,
              contentDescription = "KeyboardArrowRight",
              modifier = Modifier.size(30.dp)
          )
      }
  }
}
