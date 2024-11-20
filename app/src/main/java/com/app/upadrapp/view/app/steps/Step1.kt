package com.app.upadrapp.view.app.steps

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.upadrapp.R
import com.app.upadrapp.shared.ButtonWithIcon
import com.app.upadrapp.shared.Loader
import com.app.upadrapp.shared.NoDataFound
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.ui.theme.DarkBlue
import com.app.upadrapp.ui.theme.ProcedureBorderColor
import com.app.upadrapp.ui.theme.SubTitleColor
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.utils.NetworkResponse
import com.app.upadrapp.viewmodel.appviewmodel.ProcedureApiViewModel

@Composable
fun Step1(increment: Int, onClick: (id: String) -> Unit, navController: NavController) {
    var selectedProcedure = remember {
        mutableStateOf("")
    }
    var selectedProcedureId = remember {
        mutableStateOf("")
    }
    val procedureApiViewModel: ProcedureApiViewModel = viewModel()
    val allProcedureData = procedureApiViewModel.allProcedure.observeAsState()

    LaunchedEffect(key1 = Unit) {
        procedureApiViewModel.getAllProcedure()
    }
    Column {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.applogo),
                contentDescription = "app logo",
                modifier = Modifier.size(190.dp)
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .clip(shape = RoundedCornerShape(50.dp, 50.dp))
            .background(Color.White)
            .padding(20.dp, 15.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(text = "Welcome!", color = Color.Black, fontSize = 24)
            Subtitle(
                text = "We’re here to get you ready for your procedure and make sure you have everything you need.",
                color = Color(0xFFB9B9B9)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Subtitle(
                text = "Let’s start with determining what procedure you need to get prepared for...",
                color = SubTitleColor
            )
            Spacer(modifier = Modifier.height(10.dp))
            when (val result = allProcedureData.value) {
                is NetworkResponse.Error -> {
                    NoDataFound()
                }

                NetworkResponse.Loading -> {
                    Loader()
                }

                is NetworkResponse.Success -> {
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxWidth(),
                        columns = GridCells.Fixed(2)
                    ) {
                        result?.data?.procedures?.let {
                            items(it.toList()) { it ->
                                Box(modifier = Modifier
                                    .padding(5.dp)
                                    .clickable {
                                        selectedProcedure.value = it?.title.toString()
                                        selectedProcedureId.value = it?.procedureId.toString()
                                    }
                                    .width(160.dp)
                                    .height(50.dp)
                                    .background(
                                        if (selectedProcedure.value == it?.title) DarkBlue else Color.White,
                                        shape = MaterialTheme.shapes.small
                                    )
                                    .border(
                                        width = if (selectedProcedure.value == it?.title) 0.dp else 2.dp,
                                        color = ProcedureBorderColor,
                                        shape = MaterialTheme.shapes.small
                                    ), contentAlignment = Alignment.Center) {
                                    Title(
                                        text = it.title,
                                        color = if (selectedProcedure.value == it?.title) Color.White else ProcedureBorderColor,
                                        fontSize = 15
                                    )
                                }
                            }
                        }
                    }
                }

                null -> Box() {}
            }
        }
        when (allProcedureData.value) {
            is NetworkResponse.Success -> {
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp, 0.dp, 0.dp, 20.dp), verticalArrangement = Arrangement.Bottom
                ) {
                    ButtonWithIcon(text = "My Procedures") {
                        navController.navigate(Constant.MY_PROCEDURE_SCREEN)
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        ExtendedFloatingActionButton(
                            onClick = {
                                if (selectedProcedureId.value != "") {
                                    onClick(selectedProcedureId.value)
                                }
                            },
                            modifier = Modifier
                                .width(160.dp)
                                .height(45.dp),
                            shape = MaterialTheme.shapes.extraLarge,
                            content = {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Title(text = "Next", color = Color.White, fontSize = 16)
                                    Icon(
                                        Icons.Filled.KeyboardArrowRight,
                                        contentDescription = "Extended floating action button.",
                                        modifier = Modifier.size(25.dp)
                                    )
                                }
                            },
                            containerColor = if (selectedProcedure.value != "") DarkBlue else Color.LightGray
                        )
                    }
                }
            }

            null -> Box() {}
            is NetworkResponse.Error -> Box() {}
            NetworkResponse.Loading -> Box() {}
        }

    }
}