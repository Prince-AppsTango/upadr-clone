package com.app.upadrapp.viewmodel.appviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.upadrapp.model.appmodel.createProcedureResponseModel.CreateParameterProcedureModel
import com.app.upadrapp.model.appmodel.createProcedureResponseModel.CreateProcedureResponseModel
import com.app.upadrapp.model.repository.apprepository.AppApiRepository
import com.app.upadrapp.utils.NetworkResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class CreateProcedureApiViewModel:ViewModel() {
     private val appApiRepository = AppApiRepository()
     private val _getCreateProcedureData = MutableLiveData<NetworkResponse<CreateProcedureResponseModel>>()
     val getCreateProcedureData: LiveData<NetworkResponse<CreateProcedureResponseModel>> = _getCreateProcedureData;
     fun createUserProcedure(craParameterProcedureModel: CreateParameterProcedureModel){
           _getCreateProcedureData.value = NetworkResponse.Loading
         viewModelScope.launch {
             try {
                 val response = appApiRepository.createUserProcedure(craParameterProcedureModel)
                 Log.d("ApiCall", "Response: ${response.body()}") // Log the body of the response

                 if(response.isSuccessful && response.body() != null) {
                     response.body()?.let {
                         _getCreateProcedureData.value = NetworkResponse.Success(it)
                     }
                 } else {
                     val errorMessage = response.errorBody()?.string() ?: "An unknown error occurred"
                     Log.e("ApiCallError", errorMessage) // Log the error body
                     _getCreateProcedureData.value = NetworkResponse.Error(errorMessage)
                 }
             } catch (e: Exception) {
                 Log.e("ApiCallException", e.message.toString()) // Log the exception if one occurs
                 _getCreateProcedureData.value = NetworkResponse.Error("Failed to load data")
             }
         }
    }
}