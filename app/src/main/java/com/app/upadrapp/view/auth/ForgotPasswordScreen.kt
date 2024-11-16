package com.app.upadrapp.view.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Text
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
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.ui.theme.SubTitleColor
import com.app.upadrapp.utils.SafeArea

@Composable
fun ForgotPasswordScreen(navController: NavController) {
     val scrollState = rememberScrollState()
     SafeArea {
          Column (  modifier = Modifier
               .background(Color.White)
               .fillMaxSize(1f)
               .verticalScroll(scrollState)
          ) {
               IconButton(onClick = {
                    navController.popBackStack()
               }) {
                    Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "KeyboardArrowLeft", tint = Color.Black, modifier = Modifier.size(40.dp))
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
                   Title(text = "Forgot Your Password?", color = Color.Black)
                   Spacer(modifier = Modifier.height(10.dp))
                   Subtitle(text = "Please enter the email or phone number you signed up with to reset your password", color = SubTitleColor)
                   Spacer(modifier = Modifier.height(50.dp))
                   CustomTextField(text = "Email", value = "", placeholder = "example@email.com", onChangeValue = {
                   })
                   Spacer(modifier = Modifier.height(200.dp))
                   Box(modifier = Modifier.fillMaxWidth().padding(0.dp,0.dp,0.dp,10.dp), contentAlignment = Alignment.Center) {
                        CustomButton(text = "Send Code", width = 300, onClick = {
                        })
                   }

              }
          }
     }
}