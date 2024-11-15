package com.app.upadrapp.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.app.upadrapp.view.auth.SplashScreen
import com.app.upadrapp.view.auth.LoginScreen
import com.app.upadrapp.view.auth.WelcomeScreen
import kotlinx.coroutines.delay

@Composable
fun AppContent() {
    val showSplash = remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        showSplash.value = false
    }
    if(showSplash.value){
        SplashScreen()
    }else{
        WelcomeScreen()
    }

}