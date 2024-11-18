package com.app.upadrapp.view.app



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.upadrapp.shared.Title
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.utils.SafeArea

@Composable
fun FaqScreen(drawerState:DrawerState,navController: NavController) {
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation(elevation = 8, drawerState = drawerState,navController)
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(20.dp,10.dp)
            ) {
                Title(text = "Faq Screen", color = Black, fontSize = 24)
            }
        }
    }
}