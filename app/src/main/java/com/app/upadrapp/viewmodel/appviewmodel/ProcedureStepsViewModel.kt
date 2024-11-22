package com.app.upadrapp.viewmodel.appviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.upadrapp.model.appmodel.procedurestepsmodel.ProcedureStepsModel
import com.app.upadrapp.model.repository.apprepository.AppApiRepository
import com.app.upadrapp.utils.NetworkResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class ProcedureStepsViewModel:ViewModel() {
     private val appApiRepository = AppApiRepository()
     private val _getProcedureSteps = MutableLiveData<NetworkResponse<ProcedureStepsModel>>()
     val getProcedureSteps:LiveData<NetworkResponse<ProcedureStepsModel>> = _getProcedureSteps
     fun getUserProcedureSteps(userProcedureId:String){
        _getProcedureSteps.value = NetworkResponse.Loading
       viewModelScope.launch {
           try {
               val response = appApiRepository.getUserProcedureSteps(userProcedureId)
               Log.d("response by", "${response.body()}")
               if(response.isSuccessful && response.body() !=null){
                   response.body()?.let {
                       _getProcedureSteps.value = NetworkResponse.Success(it)
                   }
               }else{
                   _getProcedureSteps.value = NetworkResponse.Error("Failed to load data")
               }

           }catch (e:Exception){
               _getProcedureSteps.value = NetworkResponse.Error("Failed to load data")
           }
       }
    }

}