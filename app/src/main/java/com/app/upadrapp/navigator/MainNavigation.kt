package com.app.upadrapp.navigator


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.view.app.HomePage

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Constant.HOME_SCREEN ){
        composable(route=Constant.HOME_SCREEN){
            HomePage(navController = navController)
        }
    }
}
