package com.eunice.billsmanagementapp.repository

import com.eunice.billsmanagementapp.api.ApiClient
import com.eunice.billsmanagementapp.api.ApiInterface
import com.eunice.billsmanagementapp.model.LoginRequest
import com.eunice.billsmanagementapp.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
    var client= ApiClient.buildClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        return withContext(Dispatchers.IO){
            client.loginUser(loginRequest)
        }
    }
}