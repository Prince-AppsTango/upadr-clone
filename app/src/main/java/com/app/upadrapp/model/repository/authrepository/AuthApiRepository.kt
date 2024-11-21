package com.app.upadrapp.model.repository.authrepository

import com.app.upadrapp.MainActivity
import com.app.upadrapp.model.api.RetrofitInstance
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginParameterModel
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginResponseModel
import retrofit2.Response

class AuthApiRepository {
    val context = MainActivity.getAppContext()
    private val authServices = RetrofitInstance.getAuthServices(context)
    suspend fun getSignIn(loginParameterModel: LoginParameterModel):Response<LoginResponseModel>{
          return  authServices.getSignIn(loginParameterModel)
    }

}