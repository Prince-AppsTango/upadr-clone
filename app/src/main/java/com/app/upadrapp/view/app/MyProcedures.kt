package com.app.upadrapp.view.app

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.upadrapp.shared.ButtonWithIcon
import com.app.upadrapp.shared.CustomButton
import com.app.upadrapp.shared.Loader
import com.app.upadrapp.shared.NoDataFound
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.ui.theme.BorderColor
import com.app.upadrapp.ui.theme.MediumTurquoise
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.utils.NetworkResponse
import com.app.upadrapp.utils.SafeArea
import com.app.upadrapp.viewmodel.appviewmodel.UserProcedureViewModel

@Composable
fun MyProcedures(drawerState: DrawerState, navController: NavController) {
    val context = LocalContext.current
    val userProcedureViewModel: UserProcedureViewModel = viewModel()
    val getUserProcedure = userProcedureViewModel.allUserProcedure.observeAsState()
    LaunchedEffect(key1 = Unit) {
        userProcedureViewModel.getAllUserProcedure()
    }
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation(
                elevation = 8,
                drawerState = drawerState,
                navController = navController
            )

            when (val result = getUserProcedure.value) {
                is NetworkResponse.Error -> {
                    NoDataFound()
                }

                NetworkResponse.Loading -> {
                    Loader()
                }

                is NetworkResponse.Success -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(1f)
                            .padding(20.dp)
                    ) {
                        Title(text = "My Procedures", color = Black, fontSize = 20)
                        if (result.data.upcomingUserProcedures.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Subtitle(text = "Upcoming", color = BorderColor, fontSize = 20)
                            Divider(color = BorderColor)
                            LazyColumn {
                                items(result.data.upcomingUserProcedures){
                                    Spacer(modifier = Modifier.height(10.dp))
                                    ButtonWithIcon(text = it.procedure.title, fontSize = 20) {
                                        navController.navigate("${Constant.PREP_PROCESS_OVERVIEW_SCREEN}/${it.userProcedureId}")
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                }
                            }
                        }
                        if (result.data.completedUserProcedures.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Subtitle(text = "Completed", color = BorderColor, fontSize = 20)
                            Divider(color = BorderColor)
                            LazyColumn {
                                items(result.data.completedUserProcedures){
                                    Spacer(modifier = Modifier.height(10.dp))
                                    ButtonWithIcon(text = it.procedure.title, fontSize = 20) {
                                        navController.navigate("${Constant.PREP_PROCESS_OVERVIEW_SCREEN}/${it.userProcedureId}")
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                }
                            }
                        }
                        if ( result.data.upcomingUserProcedures.isNotEmpty() || result.data.completedUserProcedures.isNotEmpty()){
                            Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
                                CustomButton(text = "FAQ’s and Tips", width = 300) {
                                     navController.navigate(Constant.FAQ_SCREEN)
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                OutlinedButton(
                                    onClick = {
                                              if(result.data.upcomingUserProcedures.isNotEmpty()){
                                                  Toast.makeText(context,Constant.PROCEDURE_EXISTS,Toast.LENGTH_LONG).show()
                                              }else{

                                              }
                                    },
                                    border = BorderStroke(2.dp, MediumTurquoise),
                                    modifier = Modifier.width(300.dp).height(50.dp)
                                ) {
                                    Text(text = "Prep For Another Procedure", color = MediumTurquoise, fontSize = 16.sp, fontWeight = FontWeight.W600)
                                }
                                Spacer(modifier = Modifier.height(20.dp))
                            }
                        }
                    }
                }

                null -> {
                    NoDataFound()
                }
            }

        }
    }
}