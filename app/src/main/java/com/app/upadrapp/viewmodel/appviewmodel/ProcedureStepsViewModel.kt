package com.app.upadrapp.viewmodel.appviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.upadrapp.model.appmodel.procedurestepsmodel.ProcedureStepsModel
import com.app.upadrapp.model.repository.apprepository.AppApiRepository
import com.app.upadrapp.utils.NetworkResponse
import java.lang.Exception

class ProcedureStepsViewModel:ViewModel() {
     private val appApiRepository = AppApiRepository()
     private val _getProcedureSteps = MutableLiveData<NetworkResponse<ProcedureStepsModel>>()
     val getProcedureSteps:LiveData<NetworkResponse<ProcedureStepsModel>> = _getProcedureSteps
    suspend fun getUserProcedureSteps(userProcedureId:String){
        _getProcedureSteps.value = NetworkResponse.Loading
        try {
            val response = appApiRepository.getUserProcedureSteps(userProcedureId)
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