package com.app.upadrapp.model.repository.authrepository

import com.app.upadrapp.model.api.RetrofitInstance
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginParameterModel
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginResponseModel

class AuthApiRepository {
    private  val getRetroFitInstance = RetrofitInstance.getSignIn
    suspend fun getSignIn(loginParameterModel: LoginParameterModel):LoginResponseModel{
          return  getRetroFitInstance.getSignIn(loginParameterModel)
    }

}