package com.app.upadrapp.view.app

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
import com.app.upadrapp.viewmodel.appviewmodel.UserProcedureViewModel


@Composable
fun HomePage(navController: NavController, drawerState: DrawerState) {
    val increment = remember {
        mutableIntStateOf(1)
    }
    var selectedProcedureId = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    // CreateProcedureApiViewModel
    val createProcedureApiViewModel: CreateProcedureApiViewModel = viewModel()
    val getProcedureData = createProcedureApiViewModel.getCreateProcedureData.observeAsState()
    val toastShown = remember { mutableStateOf(false) }
    // UserProcedureViewModel
    val userProcedureViewModel: UserProcedureViewModel = viewModel()
    val getUserProcedure = userProcedureViewModel.allUserProcedure.observeAsState()
    // when i create procedure then i checked response
    when (val result = getProcedureData.value) {
        is NetworkResponse.Error -> {
            Toast.makeText(
                context,
                parseMessage(result.message) ?: result.message,
                Toast.LENGTH_LONG
            ).show()
        }

        NetworkResponse.Loading -> {}
        is NetworkResponse.Success -> {
            if (!toastShown.value) {
                Toast.makeText(context, result.data.message, Toast.LENGTH_LONG).show()
                navController.navigate(Constant.MY_PROCEDURE_SCREEN)
                toastShown.value = true
            }
        }

        null -> {}
    }
    LaunchedEffect(getUserProcedure.value) {
        when (val result = getUserProcedure.value) {
            is NetworkResponse.Error -> {}
            NetworkResponse.Loading -> {}
            is NetworkResponse.Success -> {
                if (result.data.completedUserProcedures.isNotEmpty() || result.data.upcomingUserProcedures.isNotEmpty()) {
                    increment.value = 3
                }

            }
            null -> {}
        }
    }

    LaunchedEffect(key1 = Unit) {
        userProcedureViewModel.getAllUserProcedure()
    }

    SafeArea {
        Column(
            modifier = Modifier
                .background(LightCyan)
                .fillMaxSize()
        ) {
            if (increment.value != 3) {
                TopDrawerNavigation(drawerState = drawerState, navController = navController)
            }
            when (increment.value) {
                1 -> Step1(increment = increment.value, onClick = {
                    selectedProcedureId.value = it
                    increment.value += 1
                }, navController)

                2 -> Step2(
                    onBackButtonClick = { increment.value -= 1 },
                    selectedProcedureId = selectedProcedureId.value,
                    createProcedureApiViewModel = createProcedureApiViewModel,
                    context = context
                )

                else -> MyProcedures(drawerState = drawerState, navController = navController)
            }
        }
    }
}