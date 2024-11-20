package com.app.upadrapp.view.app


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.upadrapp.shared.Title
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.utils.NetworkResponse
import com.app.upadrapp.utils.SafeArea
import com.app.upadrapp.viewmodel.appviewmodel.MeApiViewModel

@Composable
fun SettingScreen(drawerState: DrawerState, navController: NavController) {
    val meApiViewModel: MeApiViewModel = viewModel()
    val meDataObserver = meApiViewModel.meData.observeAsState()
    val meData = meDataObserver.value
    LaunchedEffect(key1 = Unit) {
        meApiViewModel.getMeData()
    }
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f)
        ) {
            TopDrawerNavigation(elevation = 8, drawerState = drawerState, navController)
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(20.dp, 10.dp)
            ) {
                Title(text = "Settings", color = Black, fontSize = 20)
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(5.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(12.dp, 0.dp), contentAlignment = Alignment.Center
                    ) {
                        (if (meData is NetworkResponse.Success) "${meData?.data?.user?.firstName} ${meData?.data?.user?.lastName}" else "NA")?.let {
                            Text(
                                text = it,
                                color = Color(0xFF666666),
                                fontWeight = FontWeight.W600,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}