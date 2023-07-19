package com.eunice.billsmanagementapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eunice.billsmanagementapp.model.LoginRequest
import com.eunice.billsmanagementapp.model.LoginResponse
import com.eunice.billsmanagementapp.model.RegisterRequest
import com.eunice.billsmanagementapp.model.RegisterResponse
import com.eunice.billsmanagementapp.repository.UserRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val regLiveData=MutableLiveData<RegisterResponse>()
    val errorLiveData=MutableLiveData<String>()
    val userRepository=UserRepository()
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response= userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}