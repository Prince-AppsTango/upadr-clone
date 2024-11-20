package com.app.upadrapp.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.view.app.HomePage
import com.app.upadrapp.view.app.PrepProcessOverviewScreen
import com.app.upadrapp.view.auth.ChangePasswordScreen
import com.app.upadrapp.view.auth.ForgotPasswordScreen
import com.app.upadrapp.view.auth.LoginScreen
import com.app.upadrapp.view.auth.SignUpScreen
import com.app.upadrapp.view.auth.VerifyOtpScreen
import com.app.upadrapp.view.auth.WelcomeScreen
import com.app.upadrapp.viewmodel.authviewmodel.LoginUserViewModel

@Composable
fun AuthNavigation(navController: NavHostController,onClick:()->Unit) {
    NavHost(navController = navController, startDestination = Constant.WELCOME_SCREEN) {
        //Auth navigation
        composable(route = Constant.WELCOME_SCREEN) {
            WelcomeScreen(navController)
        }
        composable(route = Constant.LOGIN_SCREEN) {
            LoginScreen(navController,{ onClick()})
        }
        composable(route = Constant.SIGNUP_SCREEN) {
            SignUpScreen(navController)
        }
        composable(route = Constant.FORGOT_PASSWORD_SCREEN) {
            ForgotPasswordScreen(navController)
        }
        composable(route = Constant.VERIFY_OTP_SCREEN) {
            VerifyOtpScreen(navController)
        }
        composable(route = Constant.CHANGE_PASSWORD_SCREEN) {
            ChangePasswordScreen(navController)
        }
    }
}
