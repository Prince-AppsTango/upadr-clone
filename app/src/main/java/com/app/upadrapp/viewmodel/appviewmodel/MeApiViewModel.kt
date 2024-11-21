package com.app.upadrapp.viewmodel.appviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.upadrapp.model.appmodel.medatamodel.MeDataReponseModel
import com.app.upadrapp.model.repository.apprepository.AppApiRepository
import com.app.upadrapp.utils.NetworkResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class MeApiViewModel :ViewModel() {
    private val appApiRepository = AppApiRepository()
    private val _meData = MutableLiveData<NetworkResponse<MeDataReponseModel>>()
    val meData : LiveData<NetworkResponse<MeDataReponseModel>> = _meData;
     fun getMeData(){
        _meData.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = appApiRepository.getMeData()
                if(response.isSuccessful){
                   response.body()?.let {
                       _meData.value = NetworkResponse.Success(it)
                   }
                }else{
                    _meData.value = NetworkResponse.Error("Failed to load data")
                }
            }catch (e:Exception){
                _meData.value = NetworkResponse.Error("Failed to load data")
            }
        }
    }
}