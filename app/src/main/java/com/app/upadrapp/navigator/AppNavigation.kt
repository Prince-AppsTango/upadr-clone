package com.app.upadrapp.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.upadrapp.view.auth.LoginScreen
import com.app.upadrapp.view.auth.SignUpScreen
import com.app.upadrapp.view.auth.SplashScreen
import com.app.upadrapp.view.auth.WelcomeScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavigation() {
    val showSplash = remember {
        mutableStateOf(true)
    }
    val navController = rememberNavController()
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        showSplash.value = false
    }
    if(showSplash.value){
        SplashScreen()
    }else{
        NavHost(navController = navController, startDestination = "welcome"){
            composable(route="welcome"){
                WelcomeScreen(navController)
            }
            composable(route="login"){
                LoginScreen(navController)
            }
            composable(route="signup"){
                SignUpScreen(navController)
            }
        }
    }
}