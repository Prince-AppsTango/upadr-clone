package com.app.upadrapp.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.view.auth.ForgotPasswordScreen
import com.app.upadrapp.view.auth.LoginScreen
import com.app.upadrapp.view.auth.SignUpScreen
import com.app.upadrapp.view.auth.SplashScreen
import com.app.upadrapp.view.auth.VerifyOtpScreen
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
        NavHost(navController = navController, startDestination = Constant.WELCOME_SCREEN){
            composable(route= Constant.WELCOME_SCREEN){
                WelcomeScreen(navController)
            }
            composable(route=Constant.LOGIN_SCREEN){
                LoginScreen(navController)
            }
            composable(route=Constant.SIGNUP_SCREEN){
                SignUpScreen(navController)
            }
            composable(route=Constant.FORGOT_PASSWORD_SCREEN){
              ForgotPasswordScreen(navController)
            }
            composable(route= Constant.VERIFY_OTP_SCREEN) { 
                VerifyOtpScreen(navController = navController)
            }
        }
    }
}