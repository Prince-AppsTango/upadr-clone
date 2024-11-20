package com.app.upadrapp.model.api.authservices

import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginParameterModel
import com.app.upadrapp.model.authmodel.loginuserresponsemodel.LoginResponseModel
import com.app.upadrapp.utils.EndPoints
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthServices {

    @POST(EndPoints.LOGIN_API)
    suspend fun getSignIn(@Body loginParameterModel: LoginParameterModel):Response<LoginResponseModel>
}