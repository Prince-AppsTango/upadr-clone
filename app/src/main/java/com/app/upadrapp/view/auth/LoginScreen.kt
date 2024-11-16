package com.app.upadrapp.view.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.upadrapp.R
import com.app.upadrapp.shared.CustomTextField
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.ui.theme.SubTitleColor
import com.app.upadrapp.utils.SafeArea

@Composable
fun LoginScreen(navController: NavController) {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    SafeArea {
        Column(
            modifier = Modifier
                .background(LightCyan)
                .fillMaxSize(1f)
        ) {
            Column(
                modifier = Modifier
                    .background(LightCyan)
                    .fillMaxWidth()
                    .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.applogo),
                    contentDescription = "app logo",
                    modifier = Modifier.size(220.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .clip(shape = RoundedCornerShape(50.dp, 50.dp))
                    .background(Color.White)
            ) {
                Column(modifier = Modifier.padding(20.dp, 15.dp)) {
                    Title(text = "Log in", color = Black, fontSize = 24)
                    Spacer(modifier = Modifier.height(5.dp))
                    Subtitle(
                        text = "Please enter your email and password or log in with social media",
                        color = SubTitleColor,
                        fontSize = 15
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomTextField(text = "Email", value = email.value, onChangeValue = {
                        email.value = it
                    })
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomTextField(text = "Password", value = password.value, onChangeValue = {
                        password.value = it
                    })
                }
            }
        }
    }
}