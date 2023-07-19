package com.eunice.billsmanagementapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eunice.billsmanagementapp.model.LoginRequest
import com.eunice.billsmanagementapp.model.LoginResponse
import com.eunice.billsmanagementapp.model.RegisterRequest
import com.eunice.billsmanagementapp.model.RegisterResponse
import com.eunice.billsmanagementapp.repository.LoginRepository
import com.eunice.billsmanagementapp.repository.UserRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class LoginViewModel :ViewModel(){
    val logLiveData= MutableLiveData<LoginResponse>()
    val errorLiveData= MutableLiveData<String>()
    val loginRepository=LoginRepository()
 fun loginUser(loginRequest: LoginRequest){
     viewModelScope.launch{
         val response= loginRepository.loginUser(loginRequest)
         if (response.isSuccessful){
             logLiveData.postValue(response.body())
         }
         else{
             errorLiveData.postValue(response.errorBody()?.string())
         }
        }
    }
}