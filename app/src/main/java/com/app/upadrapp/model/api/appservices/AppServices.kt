package com.app.upadrapp.model.api.appservices

import com.app.upadrapp.model.appmodel.medatamodel.MeDataReponseModel
import com.app.upadrapp.utils.EndPoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface AppServices {
    @GET(EndPoints.ME_API)
    suspend fun getMeData():Response<MeDataReponseModel>
}