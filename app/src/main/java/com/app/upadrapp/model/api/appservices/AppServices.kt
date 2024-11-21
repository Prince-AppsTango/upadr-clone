package com.app.upadrapp.model.api.appservices

import com.app.upadrapp.model.appmodel.createProcedureResponseModel.CreateParameterProcedureModel
import com.app.upadrapp.model.appmodel.createProcedureResponseModel.CreateProcedureResponseModel
import com.app.upadrapp.model.appmodel.medatamodel.MeDataReponseModel
import com.app.upadrapp.model.appmodel.proceduremodel.ProcedureModel
import com.app.upadrapp.utils.EndPoints
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AppServices {
    // Me Data
    @GET(EndPoints.ME_API)
    suspend fun getMeData():Response<MeDataReponseModel>

    //Get all procedure
    @GET(EndPoints.GET_ALL_PROCEDURE)
    suspend fun getAllProcedure(): Response<ProcedureModel>

    //Create procedure
    @POST(EndPoints.CREATE_USER_PROCEDURE)
    suspend fun createUserProcedure(@Body createParameterProcedureModel: CreateParameterProcedureModel):Response<CreateProcedureResponseModel>

}