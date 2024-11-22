package com.app.upadrapp.viewmodel.appviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.upadrapp.model.appmodel.userproceduremodel.UserProcedureModel
import com.app.upadrapp.model.repository.apprepository.AppApiRepository
import com.app.upadrapp.utils.NetworkResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class UserProcedureViewModel:ViewModel() {

    private val appApiRepository = AppApiRepository()
    private  val _allUserProcedure =  MutableLiveData<NetworkResponse<UserProcedureModel>>()
    val allUserProcedure : LiveData<NetworkResponse<UserProcedureModel>> = _allUserProcedure;
    suspend fun getAllUserProcedure(){
        _allUserProcedure.value= NetworkResponse.Loading
      viewModelScope.launch {
          try {
              val response = appApiRepository.getUserProcedure()
              if(response.isSuccessful){
                  response.body()?.let {
                      _allUserProcedure.value = NetworkResponse.Success(it)
                  }
              }else{
                  _allUserProcedure.value = NetworkResponse.Error("Error to load data")
              }
          }catch (e: Exception){
              _allUserProcedure.value = NetworkResponse.Error("Error to load data")
          }
      }
    }
}