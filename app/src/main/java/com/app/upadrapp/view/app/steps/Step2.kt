package com.app.upadrapp.view.app.steps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.upadrapp.R

@Composable
fun Step2() {
    Column {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.applogo),
                contentDescription = "app logo",
                modifier = Modifier.size(190.dp)
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .clip(shape = RoundedCornerShape(50.dp, 50.dp))
            .background(Color.White)
            .padding(20.dp, 15.dp)
    ) {}
}