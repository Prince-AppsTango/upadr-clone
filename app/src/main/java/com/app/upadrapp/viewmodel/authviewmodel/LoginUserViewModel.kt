package com.app.upadrapp.viewmodel.authviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginParameterModel
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginResponseModel
import com.app.upadrapp.model.repository.authrepository.AuthApiRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginUserViewModel : ViewModel() {
    private val getAuthApiRepository = AuthApiRepository()
    private val _loginData = MutableLiveData<LoginResponseModel?>()
    val loginData: LiveData<LoginResponseModel?> = _loginData

    fun getSignIn(loginParameterModel: LoginParameterModel) {
        viewModelScope.launch {
            try {
                val response = getAuthApiRepository.getSignIn(loginParameterModel)
                if (response.isSuccessful && response.body() != null) {
                    _loginData.value = response.body()
                } else {
                    _loginData.value = null
                }
            } catch (e: Exception) {
                _loginData.value = null
            }
        }
    }
}
