package com.app.upadrapp.model.repository.apprepository

import com.app.upadrapp.MainActivity
import com.app.upadrapp.model.api.RetrofitInstance
import com.app.upadrapp.model.appmodel.medatamodel.MeDataReponseModel
import retrofit2.Response

class AppApiRepository{
   val context = MainActivity.getAppContext()
   private  val getRetroFitInstance = RetrofitInstance.getMeData(context)
   suspend fun getMeData():Response<MeDataReponseModel> {
      return  getRetroFitInstance.getMeData()
   }
}