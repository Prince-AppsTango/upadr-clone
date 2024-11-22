package com.app.upadrapp.view.app

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.app.upadrapp.shared.AlertDialogBox

import com.app.upadrapp.shared.ConvertToDateCount
import com.app.upadrapp.shared.CustomButton
import com.app.upadrapp.shared.DropDownMenuForPrep
import com.app.upadrapp.shared.Loader
import com.app.upadrapp.shared.NoDataFound
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.shared.TopDrawerNavigation
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.ui.theme.MediumTurquoise
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.utils.NetworkResponse
import com.app.upadrapp.utils.SafeArea
import com.app.upadrapp.utils.prepSteps
import com.app.upadrapp.viewmodel.appviewmodel.ProcedureStepsViewModel
import java.util.concurrent.TimeUnit

@Composable
fun PrepProcessOverviewScreen(
    navController: NavController,
    drawerState: DrawerState,
    userProcedureId: String
) {
    val scrollState = rememberScrollState()
    val isCancelBoxOpen = remember {
        mutableStateOf(false)
    }
    val mDisplayMenu = remember {
        mutableStateOf(false)
    }
    val procedureStepsViewModel: ProcedureStepsViewModel = viewModel()
    val getProcedureStep = procedureStepsViewModel.getProcedureSteps.observeAsState()
    LaunchedEffect(key1 = userProcedureId) {
        procedureStepsViewModel.getUserProcedureSteps(userProcedureId)
    }
    SafeArea {
        Column {
            TopDrawerNavigation(elevation = 8, drawerState = drawerState, navController)
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(1f)
                    .verticalScroll(scrollState)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 10.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
                        Box(modifier = Modifier.fillMaxWidth(0.9f)) {
                            Title(
                                text = "Great! Here’s an overview on what your colonoscopy prep process will look like.",
                                color = Black,
                                fontSize = 20
                            )
                        }
                        IconButton(
                            onClick = {
                                mDisplayMenu.value = true
                            },
                            modifier = Modifier
                                .size(60.dp)
                        ) {
                            Icon(
                                Icons.Filled.MoreVert,
                                contentDescription = "MoreVert",
                                tint = Color.Gray
                            )
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            DropDownMenuForPrep(mDisplayMenu = mDisplayMenu.value, onCancel = {
                                isCancelBoxOpen.value = true
                                mDisplayMenu.value = false
                            }, onEdit = {}, onDismissRequest = { mDisplayMenu.value = false })
                        }
                    }
                    Subtitle(
                        text = "But don’t worry! We will send you notification when these things need to get done so you don’t have to remember it all. ",
                        color = Black
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                when (val result = getProcedureStep.value) {
                    is NetworkResponse.Error -> {
                        NoDataFound()
                    }

                    NetworkResponse.Loading -> {
                        Loader()
                    }

                    is NetworkResponse.Success -> {
                        result.data.userProcedures.procedure.steps.forEachIndexed { index, prepStep ->
                            if (index % 2 == 0) {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f)
                                            .padding(20.dp, 0.dp, 0.dp, 0.dp)
                                    ) {
                                        Title(text = "Step ${index + 1}", color = Black)
                                        Title(
                                            text = "${ConvertToDateCount(prepStep.`when`)} ${
                                                if (prepStep.isBeforeProcedure) "before" else "after"
                                            } procedure",
                                            color = Black
                                        )
                                        Subtitle(
                                            text = prepStep.description,
                                            color = Black,
                                            maxLines = 6
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "See More Details",
                                            color = MediumTurquoise,
                                            fontWeight = FontWeight.SemiBold,
                                            modifier = Modifier.clickable {
                                                navController.navigate(Constant.PREP_PROCESS_OVERVIEW_DETAILS_SCREEN)
                                            })
                                    }
                                    Box(
                                        modifier = Modifier
                                            .height(200.dp)
                                            .width(200.dp)
                                            .offset(y = 30.dp, x = 20.dp)
                                            .clip(RoundedCornerShape(100.dp))
                                            .background(Color.Gray)
                                            .border(
                                                2.dp,
                                                Color.Gray,
                                                MaterialTheme.shapes.extraLarge
                                            )
                                    ) {
                                        AsyncImage(
                                            model = prepStep.procedureStepImageUrl,
                                            contentDescription = "${index + 1}",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(30.dp))
                            } else {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Box(
                                        modifier = Modifier
                                            .height(200.dp)
                                            .width(200.dp)
                                            .offset(y = 30.dp, x = (-20).dp)
                                            .clip(RoundedCornerShape(100.dp))
                                            .background(Color.Gray)
                                            .border(
                                                2.dp,
                                                Color.Gray,
                                                MaterialTheme.shapes.extraLarge
                                            )
                                    ) {
                                        AsyncImage(
                                            model = prepStep.procedureStepImageUrl,
                                            contentDescription = "${index + 1}",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(0.dp, 0.dp, 20.dp, 0.dp),
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        Title(text = "Step ${index + 1}", color = Black)
                                        Text(
                                            text = "${ConvertToDateCount(prepStep.`when`)} ${
                                                if (prepStep.isBeforeProcedure) "before" else "after"
                                            } procedure",
                                            color = Black,
                                            textAlign = TextAlign.Right,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                        Text(
                                            text = prepStep.description,
                                            color = Black,
                                            fontWeight = FontWeight.Normal,
                                            textAlign = TextAlign.Right,
                                            maxLines = 6
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = "See More Details",
                                            color = MediumTurquoise,
                                            fontWeight = FontWeight.SemiBold,
                                            modifier = Modifier.clickable {
                                                navController.navigate(Constant.PREP_PROCESS_OVERVIEW_DETAILS_SCREEN)
                                            })
                                    }
                                }
                                Spacer(modifier = Modifier.height(30.dp))
                            }
                            Spacer(modifier = Modifier.height(30.dp))
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CustomButton(text = "FAQ’s and Tips", width = 300) {
                                navController.navigate(Constant.TIPS_SCREEN)
                            }
                        }
                        Spacer(modifier = Modifier.height(40.dp))
                        if (isCancelBoxOpen.value) {
                            AlertDialogBox(
                                onDismissRequest = { isCancelBoxOpen.value = false },
                                onConfirmation = { },
                                dialogTitle = "Cancel Procedure",
                                dialogText = "Are you sure you want to cancel your procedure? This process is irreversible and you will have to re-enter your information later."
                            )
                        }
                    }

                    null -> {
                        NoDataFound()
                    }
                }

            }
        }

    }
}
