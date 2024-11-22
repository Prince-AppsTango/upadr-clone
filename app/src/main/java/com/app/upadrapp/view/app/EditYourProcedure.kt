package com.app.upadrapp.view.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.upadrapp.shared.BackButtonNavigation
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.utils.SafeArea

@Composable
fun EditYourProcedure(navController:NavController) {
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f)
        ) {
            BackButtonNavigation(elevation = 8,navController)
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(20.dp,10.dp)
            ) {
                Title(text = "Edit Your Procedure", color = Black, fontSize = 20)
            }
        }
    }
}