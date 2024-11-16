package com.app.upadrapp.view.app.steps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.upadrapp.R
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.ProcedureBorderColor
import com.app.upadrapp.ui.theme.SubTitleColor

@Composable
fun Step1() {
    val data = listOf("#Procedures1","#Procedures2","#Procedures3","#Procedures4","#Procedures5","#Procedures6")
     Column {
         Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
             Image(
                 painter = painterResource(id = R.drawable.applogo),
                 contentDescription = "app logo",
                 modifier = Modifier.size(220.dp)
             )
         }
     }
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .clip(shape = RoundedCornerShape(50.dp, 50.dp))
            .background(Color.White)
            .padding(20.dp, 15.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Title(text = "Welcome!", color = Color.Black, fontSize = 24)
            Subtitle(text = "We’re here to get you ready for your procedure and make sure you have everything you need.", color = Color(0xFFB9B9B9))
            Spacer(modifier = Modifier.height(10.dp))
            Subtitle(text = "Let’s start with determining what procedure you need to get prepared for...", color = SubTitleColor)
            Spacer(modifier = Modifier.height(10.dp))
            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth(),
                columns = GridCells.Fixed(2)
            ) {
                items(data) { it ->
                    Box(modifier = Modifier.padding(5.dp).clickable {  }.width(160.dp).height(50.dp).border(
                        width = 2.dp,
                        color = ProcedureBorderColor,
                        shape = MaterialTheme.shapes.small
                    ), contentAlignment = Alignment.Center) {
                        Text(text = it.toString(), color = Color.Black)
                    }
                }
            }

        }
    }
}