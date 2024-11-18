package com.app.upadrapp.view.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.upadrapp.shared.Title
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.ui.theme.DarkBlue
import com.app.upadrapp.utils.SafeArea

@Composable
fun TipsScreen(drawerState: DrawerState) {
    val data = listOf(
        "#Procedures1",
        "#Procedures2",
        "#Procedures3",
        "#Procedures4",
        "#Procedures5",
        "#Procedures6",
    )
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation(elevation = 8, drawerState = drawerState)
                LazyColumn {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(1f)
                                .padding(20.dp,10.dp)
                        ) {
                            Title(text = "FAQs and Tips", color = Black, fontSize = 24)
                        }
                    }
                    items(data){
                        Card(
                            modifier = Modifier
                                .fillMaxWidth().clickable {  }
                                .height(70.dp)
                                .padding(20.dp, 8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(5.dp),
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text(text = it, color = DarkBlue, fontSize = 15.sp )
                            }

                        }
                    }
                }
            }
        }
}