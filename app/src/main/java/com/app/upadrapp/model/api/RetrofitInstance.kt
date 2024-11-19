package com.app.upadrapp.model.api

import com.app.upadrapp.model.api.authservices.AuthServices
import com.app.upadrapp.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val getSignIn: AuthServices by lazy {
        retrofit.create(AuthServices::class.java)
    }
}