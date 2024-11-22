package com.app.upadrapp.model.api

import android.content.Context
import com.app.upadrapp.model.api.appservices.AppServices
import com.app.upadrapp.model.api.authservices.AuthServices
import com.app.upadrapp.store.getAccessTokenSync
import com.app.upadrapp.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    fun getInstance(context: Context): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val accessToken = getAccessTokenSync(context)
                val request = chain.request().newBuilder().apply {
                    addHeader("Authorization", "Bearer $accessToken")
                }.build()
                chain.proceed(request)
            }
            .build()
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    fun getAuthServices(context:Context): AuthServices {
        return getInstance(context).create(AuthServices::class.java)
    }
    fun getAppServices(context: Context): AppServices {
        return getInstance(context).create(AppServices::class.java)
    }
}
