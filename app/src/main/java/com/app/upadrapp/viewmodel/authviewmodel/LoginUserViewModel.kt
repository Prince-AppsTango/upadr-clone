package com.app.upadrapp.viewmodel.authviewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginParameterModel
import com.app.upadrapp.model.repository.authrepository.AuthApiRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginUserViewModel : ViewModel() {
    private val getAuthApiRepository = AuthApiRepository()

    fun getSignIn(loginParameterModel: LoginParameterModel) {
        viewModelScope.launch {
            try {
                val response = getAuthApiRepository.getSignIn(loginParameterModel)
                Log.d("userData", response.toString())
            } catch (e: Exception) {
                Log.d("login Error", "Error occur")
            }
        }
    }
}