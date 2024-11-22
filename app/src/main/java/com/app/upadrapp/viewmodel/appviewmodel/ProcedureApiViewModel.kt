package com.app.upadrapp.viewmodel.appviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.upadrapp.model.appmodel.proceduremodel.ProcedureModel
import com.app.upadrapp.model.repository.apprepository.AppApiRepository
import com.app.upadrapp.utils.NetworkResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class ProcedureApiViewModel:ViewModel() {
    private val appApiRepository = AppApiRepository()
    private  val _allProcedure =  MutableLiveData<NetworkResponse<ProcedureModel>>()
    val allProcedure : LiveData<NetworkResponse<ProcedureModel>> = _allProcedure;
    suspend fun getAllProcedure(){
        _allProcedure.value=NetworkResponse.Loading
       viewModelScope.launch {
           try {
               val response = appApiRepository.getAllProcedure()
               if(response.isSuccessful){
                   response.body()?.let {
                       _allProcedure.value = NetworkResponse.Success(it)
                   }
               }else{
                   _allProcedure.value = NetworkResponse.Error("Error to load data")
               }
           }catch (e:Exception){
               _allProcedure.value = NetworkResponse.Error("Error to load data")
           }
       }
    }
}