package com.app.upadrapp.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.upadrapp.ui.theme.LightSlateBlue
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightSlateBlue)
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            IconButton(onClick = {
                scope.launch {
                    drawerState.close()
                }
            }) {
                Icon(
                    Icons.Filled.Clear,
                    contentDescription = "Clear",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(50.dp)) {
            DrawerMenuItem("My Procedures")
            DrawerMenuItem("Tips")
            DrawerMenuItem("Surveys")
            DrawerMenuItem("Settings")
            DrawerMenuItem("Notifications")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Filled.DateRange, contentDescription = "DateRange", tint = Color.White)
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "Log Out",
                    color = Color.White,
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun DrawerMenuItem(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(Icons.Filled.DateRange, contentDescription = "DateRange", tint = Color.White)
        TextButton(onClick = { /* TODO */ }) {
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.W400,
                fontSize = 15.sp
            )
        }
    }
}
