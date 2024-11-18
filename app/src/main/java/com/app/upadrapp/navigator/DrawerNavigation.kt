package com.app.upadrapp.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.upadrapp.shared.DrawerContent
import com.app.upadrapp.ui.theme.LightSlateBlue
import com.app.upadrapp.ui.theme.MediumTurquoise

@Composable
fun DrawerNavigation(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(drawerState, navController)
            }
        },
    ) {
        Scaffold(
            content = { _ ->
                Box(
                    modifier = Modifier.padding(0.dp)
                ) {
                    MainNavigation(navController = navController, drawerState = drawerState)
                }
            }
        )
    }

}
