package com.app.upadrapp.navigator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DrawerNavigation(navController: NavHostController) {
    Scaffold(
        content = { _ ->
            Box(
                modifier = Modifier.padding(0.dp)
            ) {
                MainNavigation(navController = navController)
            }
        }
    )
}
