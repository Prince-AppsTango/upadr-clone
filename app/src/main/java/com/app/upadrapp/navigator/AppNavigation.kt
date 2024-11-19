package com.app.upadrapp.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.app.upadrapp.view.auth.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavigation() {
    val showSplash = remember { mutableStateOf(true) }
    val navController = rememberNavController()
    val isAuthenticated = remember {
        mutableStateOf(false)
    }

        LaunchedEffect(Unit) {
        delay(3000) // Show splash screen for 3 seconds
        showSplash.value = false
    }

    if (showSplash.value) {
        SplashScreen()
    } else {
        if(isAuthenticated.value){
           DrawerNavigation(navController = navController)
        }else{
            AuthNavigation(navController){
                isAuthenticated.value = false
            }
        }
    }
}
