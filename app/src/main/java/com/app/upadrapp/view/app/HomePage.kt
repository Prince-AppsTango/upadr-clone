package com.app.upadrapp.view.app

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.utils.NetworkResponse
import com.app.upadrapp.utils.SafeArea
import com.app.upadrapp.utils.parseMessage
import com.app.upadrapp.view.app.steps.Step1
import com.app.upadrapp.view.app.steps.Step2
import com.app.upadrapp.viewmodel.appviewmodel.CreateProcedureApiViewModel
import com.app.upadrapp.viewmodel.appviewmodel.MeApiViewModel
import com.app.upadrapp.viewmodel.appviewmodel.ProcedureApiViewModel

@Composable
fun HomePage(navController: NavController, drawerState: DrawerState) {
    val context = LocalContext.current
    val createProcedureApiViewModel: CreateProcedureApiViewModel = viewModel()
    val getProcedureData = createProcedureApiViewModel.getCreateProcedureData.observeAsState()
    val toastShown = remember { mutableStateOf(false) }
    val increment = remember {
        mutableIntStateOf(1)
    }
    var selectedProcedureId = remember {
        mutableStateOf("")
    }
    getProcedureData.value?.let { result ->
        when (result) {
            is NetworkResponse.Error -> {
                if (!toastShown.value) {
                    Toast.makeText(context, parseMessage(result.message), Toast.LENGTH_LONG).show()
                    toastShown.value = true // Set to true to avoid showing again
                }
            }
            NetworkResponse.Loading -> {
            }
            is NetworkResponse.Success -> {
                if (!toastShown.value) {
                    Toast.makeText(context, result.data.message, Toast.LENGTH_LONG).show()
                    navController.navigate(Constant.PREP_PROCESS_OVERVIEW_SCREEN)
                    toastShown.value = true
                }
            }
        }
    }

    SafeArea {
        Column(
            modifier = Modifier
                .background(LightCyan)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation(drawerState = drawerState, navController = navController)
            if (increment.value == 1) {
                Step1(increment = increment.value, onClick = {
                    selectedProcedureId.value = it
                    increment.value += 1
                }, navController)
            } else {
                Step2(
                    onBackButtonClick = { increment.value -= 1 },
                    selectedProcedureId = selectedProcedureId.value,
                    createProcedureApiViewModel = createProcedureApiViewModel
                )
            }
        }
    }
}