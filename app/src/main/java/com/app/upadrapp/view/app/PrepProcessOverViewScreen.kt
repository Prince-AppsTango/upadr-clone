package com.app.upadrapp.view.app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.utils.SafeArea

@Composable
fun PrepProcessOverviewScreen(navController: NavController, drawerState: DrawerState) {
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation(elevation = 8, drawerState = drawerState, navController)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp)
            ) {
                Title(
                    text = "Great! Here’s an overview on what your colonoscopy prep process will look like.",
                    color = Black,
                    fontSize = 20
                )
                Subtitle(
                    text = "But don’t worry! We will send you notification when these things need to get done so you don’t have to remember it all. ",
                    color = Black
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(20.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Title(text = "Step 1", color = Black)
                    Title(text = "3 days before procedure", color = Black)
                    Subtitle(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris ",
                        color = Black,
                        maxLines = 6
                    )
                }
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .offset(y = 30.dp, x = 20.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color.Gray)
                        .border(2.dp, Color.Gray, MaterialTheme.shapes.extraLarge)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .offset(y = 30.dp, x = (-20).dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color.Gray)
                        .border(2.dp, Color.Gray, MaterialTheme.shapes.extraLarge)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 20.dp, 0.dp), horizontalAlignment = Alignment.End
                ) {
                    Title(text = "Step 1", color = Black)
                    Text(
                        text = "3 days before procedure",
                        color = Black,
                        textAlign = TextAlign.Right,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris ",
                        color = Black,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Right,
                        maxLines = 6
                    )
                }
            }

        }
    }
}

