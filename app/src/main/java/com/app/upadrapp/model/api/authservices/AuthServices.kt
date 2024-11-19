package com.app.upadrapp.model.api.authservices

import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginParameterModel
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthServices {

    @POST("auth/login")
    suspend fun getSignIn(@Body loginParameterModel: LoginParameterModel):LoginResponseModel
}