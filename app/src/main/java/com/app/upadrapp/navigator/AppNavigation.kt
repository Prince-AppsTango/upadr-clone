package com.app.upadrapp.navigator

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.app.upadrapp.store.getAccessToken
import com.app.upadrapp.utils.NetworkResponse
import com.app.upadrapp.view.auth.SplashScreen
import com.app.upadrapp.viewmodel.authviewmodel.LoginUserViewModel
import kotlinx.coroutines.delay

@Composable
fun AppNavigation() {
    val context = LocalContext.current
    val showSplash = remember { mutableStateOf(true) }
    val navController = rememberNavController()
    val accessToken = getAccessToken(context).collectAsState(initial = "")
    val isAuthenticated = remember {
        mutableStateOf(false)
    }
        LaunchedEffect(Unit) {
        delay(3000)
        showSplash.value = false
    }

    if (showSplash.value) {
        SplashScreen()
    } else {
        if(accessToken.value != ""){
           DrawerNavigation(navController = navController)
        }else{
            AuthNavigation(navController,{  isAuthenticated.value= false})
        }
    }
}
