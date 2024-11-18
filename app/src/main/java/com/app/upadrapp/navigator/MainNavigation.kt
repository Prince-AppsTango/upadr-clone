package com.app.upadrapp.navigator


import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.view.app.HomePage
import com.app.upadrapp.view.app.MyProcedures
import com.app.upadrapp.view.app.PrepProcessOverviewScreen
import com.app.upadrapp.view.app.TipsScreen

@Composable
fun MainNavigation(navController: NavHostController,drawerState: DrawerState) {
    NavHost(navController = navController, startDestination = Constant.HOME_SCREEN ){
        composable(route = Constant.HOME_SCREEN) {
            HomePage(navController,drawerState)
        }
        composable(route = Constant.PREP_PROCESS_OVERVIEW_SCREEN) {
            PrepProcessOverviewScreen(navController,drawerState)
        }
        composable(route = Constant.MY_PROCEDURE_SCREEN) {
            MyProcedures(drawerState)
        }
        composable(route = Constant.TIPS_SCREEN) {
            TipsScreen(drawerState)
        }
    }
}
