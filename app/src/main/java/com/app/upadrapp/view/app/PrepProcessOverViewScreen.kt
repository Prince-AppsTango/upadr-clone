package com.app.upadrapp.view.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.utils.SafeArea

@Composable
fun PrepProcessOverviewScreen(navController: NavController,drawerState: DrawerState) {
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation( elevation = 8, drawerState = drawerState)
        }
    }
}