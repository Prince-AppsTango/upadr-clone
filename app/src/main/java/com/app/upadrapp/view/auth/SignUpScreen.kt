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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.upadrapp.R
import com.app.upadrapp.shared.CustomButton
import com.app.upadrapp.shared.CustomTextField
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.ui.theme.MediumTurquoise
import com.app.upadrapp.ui.theme.SubTitleColor
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.utils.SafeArea

@Composable
fun SignUpScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    SafeArea {
        Column(
            modifier = Modifier
                .background(LightCyan)
                .fillMaxSize(1f).verticalScroll(scrollState)
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
                    Title(text = "Sign up", color = Black, fontSize = 24)
                    Spacer(modifier = Modifier.height(5.dp))
                    Subtitle(
                        text = "Please enter your email and password or sign up with social media",
                        color = SubTitleColor,
                        fontSize = 15
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        CustomTextField(
                            text = "First Name",
                            value = "",
                            placeholder = "First Name",
                            onChangeValue = {
                            },
                            width = 170
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        CustomTextField(
                            text = "Last Name",
                            value = "",
                            placeholder = "Last Name",
                            onChangeValue = {
                            },
                            width = 170
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(text = "Email", placeholder = "example@email.com", value = "", onChangeValue = {
                    })
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(text = "Password", placeholder = "password", value = "", onChangeValue = {
                    })
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(text = "Confirm Password", placeholder = "confirm password", value = "", onChangeValue = {
                    })
                    Spacer(modifier = Modifier.height(30.dp))
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CustomButton(text = "Sign up", width = 300, onClick = {
                        })
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                        Image(painter = painterResource(id = R.drawable.googlelogo),
                            contentDescription = "googleLogo",
                            modifier = Modifier
                                .size(70.dp)
                                .clickable { })
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxSize(1f), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
                        Subtitle(text = "Already have an account? ", color = SubTitleColor)
                        Subtitle(text = "Log in", color = MediumTurquoise, modifier = Modifier.clickable {
                            navController.navigate(Constant.LOGIN_SCREEN)
                        })
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    }
            }
        }
    }
}