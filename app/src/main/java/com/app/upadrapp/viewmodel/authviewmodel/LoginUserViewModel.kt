package com.app.upadrapp.viewmodel.authviewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginParameterModel
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginResponseModel
import com.app.upadrapp.model.repository.authrepository.AuthApiRepository
import com.app.upadrapp.store.saveToDataStore
import com.app.upadrapp.utils.NetworkResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginUserViewModel : ViewModel() {
    private val getAuthApiRepository = AuthApiRepository()
    private val _loginData = MutableLiveData<NetworkResponse<LoginResponseModel>>()
    val loginData: LiveData<NetworkResponse<LoginResponseModel>> = _loginData

    fun getSignIn(context:Context,loginParameterModel: LoginParameterModel) {
            _loginData.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = getAuthApiRepository.getSignIn(loginParameterModel)
                if (response.isSuccessful && response.body() != null) {
                     response.body()?.let {
                         _loginData.value = NetworkResponse.Success(it)
                          saveToDataStore(context = context,it.tokens.accessToken, it.tokens.refreshToken)
                     }
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "An unknown error occurred"
                    _loginData.value = NetworkResponse.Error(errorMessage)
                }
            } catch (e: Exception) {
                Log.d("LoginData","${e.message}")
                _loginData.value = NetworkResponse.Error("Failed to login")
            }
        }
    }
}
