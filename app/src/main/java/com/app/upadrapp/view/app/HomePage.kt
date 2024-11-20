package com.app.upadrapp.view.app

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.utils.SafeArea
import com.app.upadrapp.view.app.steps.Step1
import com.app.upadrapp.view.app.steps.Step2
import com.app.upadrapp.viewmodel.appviewmodel.MeApiViewModel

@Composable
fun HomePage(navController: NavController,drawerState: DrawerState) {
   val increment = remember {
       mutableIntStateOf(1)
   }
    val meApiViewModel:MeApiViewModel = viewModel()
    LaunchedEffect(key1 = Unit) {
        meApiViewModel.getMeData()
    }
    SafeArea {
        Column(
            modifier = Modifier
                .background(LightCyan)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation(drawerState = drawerState, navController = navController)
            if(increment.value==1){
                Step1(increment = increment.value, onClick = { increment.value += 1 },navController)
            }else{
                Step2(onClick = {
                                navController.navigate(Constant.PREP_PROCESS_OVERVIEW_SCREEN)
                }, onBackButtonClick = {increment.value -= 1})
            }
        }
    }
}