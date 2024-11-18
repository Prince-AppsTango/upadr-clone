package com.app.upadrapp.view.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.upadrapp.shared.ButtonWithIcon
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.ui.theme.BorderColor
import com.app.upadrapp.utils.SafeArea

@Composable
fun MyProcedures(drawerState: DrawerState,navController: NavController) {
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation( elevation = 8, drawerState = drawerState, navController = navController)
            Column(  modifier = Modifier
                .fillMaxSize(1f)
                .padding(20.dp)) {
                Title(text = "My Procedures", color = Black, fontSize = 24)
                Spacer(modifier = Modifier.height(10.dp))
                Subtitle(text = "Upcoming", color = BorderColor, fontSize = 20)
                Divider(color = BorderColor)
                Spacer(modifier = Modifier.height(10.dp))
                ButtonWithIcon(text = "Colonoscopy", fontSize = 20,{})
                Spacer(modifier = Modifier.height(25.dp))
                Subtitle(text = "Completed", color = BorderColor, fontSize = 20)
                Divider(color = BorderColor)
                Spacer(modifier = Modifier.height(10.dp))
                ButtonWithIcon(text = "Colonoscopy", fontSize = 20,{} )
            }
        }
    }
}