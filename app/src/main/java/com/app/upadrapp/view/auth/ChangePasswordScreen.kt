package com.app.upadrapp.view.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.upadrapp.R
import com.app.upadrapp.shared.CustomButton
import com.app.upadrapp.shared.CustomTextField
import com.app.upadrapp.shared.OtpInputBox
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.MediumTurquoise
import com.app.upadrapp.ui.theme.SubTitleColor
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.utils.SafeArea

@Composable
fun ChangePasswordScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    SafeArea {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f).verticalScroll(scrollState)

        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "KeyboardArrowLeft",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.applogo),
                    contentDescription = "app logo",
                    modifier = Modifier.size(220.dp)
                )
            }
            Column(modifier = Modifier
                .fillMaxSize(1f)
                .padding(20.dp, 0.dp)) {
                Title(text = "Create New Password", color = Color.Black, fontSize = 24)
                Spacer(modifier = Modifier.height(10.dp))
                Subtitle(text = "Please enter the 6 digit code sent to email@example.com", color = SubTitleColor)
                Spacer(modifier = Modifier.height(20.dp))
                OtpInputBox()
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Subtitle(text = "Didn’t receive the code? ", color = SubTitleColor)
                    Subtitle(text = "Resend", color = MediumTurquoise, modifier = Modifier.clickable {
                    })
                }
                Spacer(modifier = Modifier.height(40.dp))
                Subtitle(text = "Your new password must be different from your previously used password", color = SubTitleColor)
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(text = "New Password", value = "", placeholder = "New Password", onChangeValue = {
                })
                Spacer(modifier = Modifier.height(15.dp))
                CustomTextField(text = "Confirm Password", value = "", placeholder = "Confirm Password", onChangeValue = {
                })
                Spacer(modifier = Modifier.height(20.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 10.dp), contentAlignment = Alignment.Center) {
                    CustomButton(text = "Confirm", width = 300, onClick = {
                       navController.navigate(Constant.LOGIN_SCREEN)
                    })
                }
                Spacer(modifier = Modifier.height(20.dp))
            }

        }
    }
}