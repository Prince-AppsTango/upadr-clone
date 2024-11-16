package com.app.upadrapp.view.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.app.upadrapp.shared.TopDrawerNavigation

import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.utils.SafeArea

@Composable
fun HomePage(navController: NavController) {
    SafeArea {
        Column(
            modifier = Modifier
                .background(LightCyan)
                .fillMaxSize(1f)
        ){
            TopDrawerNavigation()
        }
    }
}