package com.app.upadrapp.view.auth

import android.util.Log
import android.util.Patterns
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.app.upadrapp.R
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginParameterModel
import com.app.upadrapp.shared.CustomButton
import com.app.upadrapp.shared.CustomTextField
import com.app.upadrapp.shared.ErrorText
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.Black
import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.ui.theme.MediumTurquoise
import com.app.upadrapp.ui.theme.SubTitleColor
import com.app.upadrapp.utils.Constant
import com.app.upadrapp.utils.NetworkResponse
import com.app.upadrapp.utils.SafeArea
import com.app.upadrapp.utils.parseMessage
import com.app.upadrapp.viewmodel.authviewmodel.LoginUserViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject

@Composable
fun LoginScreen(navController: NavController,onClick:() -> Unit) {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val isEmailValid = remember { mutableStateOf(true) }
    val isPasswordValid = remember {
        mutableStateOf(true)
    }
    val authViewModel:LoginUserViewModel = viewModel()
    val loginData = authViewModel.loginData.observeAsState()
    val data = loginData.value
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    SafeArea {
        Column(
            modifier = Modifier
                .background(LightCyan)
                .fillMaxSize(1f)
                .verticalScroll(scrollState)
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
                    CustomTextField(text = "Email", value = email.value, placeholder = "example@email.com", isError = !isEmailValid.value, onChangeValue = {
                        email.value = it
                        isEmailValid.value = isValidEmail(it)
                    })
                    if (!isEmailValid.value) {
                        ErrorText(
                            text = "Please enter a valid email address",
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomTextField(text = "Password", placeholder = "password", value = password.value, isError = !isPasswordValid.value, onChangeValue = {
                        password.value = it
                        isPasswordValid.value = isValidPassword(it)
                    })
                    if (!isPasswordValid.value) {
                        ErrorText(
                            text = "Please enter a valid password",
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Forgot Password?", modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Constant.FORGOT_PASSWORD_SCREEN)
                        }, textAlign = TextAlign.End, color = MediumTurquoise)
                    Spacer(modifier = Modifier.height(30.dp))
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CustomButton(text = "Login", width = 300, loading = data is NetworkResponse.Loading, onClick = {
                            if(email.value !=""  && password.value !=""){
                                onClick()
                                val data = LoginParameterModel(
                                    emailAddress = email.value,
                                    password = password.value
                                )
                                authViewModel.getSignIn(context,data)
                            }
                        })
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                        Image(painter = painterResource(id = R.drawable.googlelogo), contentDescription = "googleLogo" , modifier = Modifier
                            .size(70.dp)
                            .clickable { })
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Row(modifier = Modifier.fillMaxSize(1f), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
                       Subtitle(text = "Don’t have an account yet? ", color = SubTitleColor)
                       Subtitle(text = "Sign up", color = MediumTurquoise, modifier = Modifier.clickable {
                           navController.navigate(Constant.SIGNUP_SCREEN)
                       })
                    }
                }
            }
        }
    }
   // error and success message handler
    when(data){
        is NetworkResponse.Error ->{
            Toast.makeText(context, parseMessage(data.message),Toast.LENGTH_LONG).show()
        }
        NetworkResponse.Loading -> Box(){}
        is NetworkResponse.Success -> {
            data.let {
                Toast.makeText(context, it.data.message,Toast.LENGTH_LONG).show()
            }
        }
        null -> Box(){}
    }
}

//reference from google
fun isValidEmail(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
fun isValidPassword(password: String): Boolean {
    val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}\$")
    return passwordRegex.matches(password)
}

