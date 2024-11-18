package com.app.upadrapp.navigator


import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.view.app.FaqScreen
import com.app.upadrapp.view.app.HomePage
import com.app.upadrapp.view.app.MyProcedures
import com.app.upadrapp.view.app.NotificationScreen
import com.app.upadrapp.view.app.PrepProcessOverviewScreen
import com.app.upadrapp.view.app.SettingScreen
import com.app.upadrapp.view.app.SurveyScreen
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
            MyProcedures(drawerState, navController )
        }
        composable(route = Constant.TIPS_SCREEN) {
            TipsScreen(drawerState,navController)
        }
        composable(route = Constant.SURVEY_SCREEN) {
            SurveyScreen(drawerState,navController)
        }
        composable(route = Constant.SETTING_SCREEN) {
            SettingScreen(drawerState,navController)
        }
        composable(route = Constant.NOTIFICATION_SCREEN) {
            NotificationScreen(drawerState,navController)
        }
        composable(route = Constant.FAQ_SCREEN) {
            FaqScreen(drawerState,navController)
        }
    }
}
