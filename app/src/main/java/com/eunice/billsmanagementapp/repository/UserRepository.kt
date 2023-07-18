package com.eunice.billsmanagementapp.repository

import com.eunice.billsmanagementapp.api.ApiClient
import com.eunice.billsmanagementapp.api.ApiInterface
import com.eunice.billsmanagementapp.model.RegisterRequest
import com.eunice.billsmanagementapp.model.RegisterResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var client=ApiClient.buildClient(ApiInterface::class.java)
    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse>{
        return withContext(Dispatchers.IO){
            client.registerUser(registerRequest)
        }
    }
}