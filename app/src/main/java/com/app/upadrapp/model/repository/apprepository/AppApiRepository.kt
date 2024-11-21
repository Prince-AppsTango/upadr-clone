package com.app.upadrapp.model.repository.apprepository

import com.app.upadrapp.MainActivity
import com.app.upadrapp.model.api.RetrofitInstance
import com.app.upadrapp.model.appmodel.createProcedureResponseModel.CreateParameterProcedureModel
import com.app.upadrapp.model.appmodel.createProcedureResponseModel.CreateProcedureResponseModel
import com.app.upadrapp.model.appmodel.medatamodel.MeDataReponseModel
import com.app.upadrapp.model.appmodel.proceduremodel.ProcedureModel
import com.app.upadrapp.model.appmodel.userproceduremodel.UserProcedureModel
import retrofit2.Response

class AppApiRepository{
   val context = MainActivity.getAppContext()
   private val appServices = RetrofitInstance.getAppServices(context)
   suspend fun getMeData():Response<MeDataReponseModel> {
      return  appServices.getMeData()
   }
   suspend fun getAllProcedure():Response<ProcedureModel>{
      return  appServices.getAllProcedure()
   }
   suspend fun createUserProcedure(createParameterProcedureModel: CreateParameterProcedureModel):Response<CreateProcedureResponseModel>{
      return  appServices.createUserProcedure(createParameterProcedureModel)
   }

   suspend fun getUserProcedure():Response<UserProcedureModel>{
      return  appServices.getUserProcedure()
   }
}