package com.eunice.billsmanagementapp.api

import com.eunice.billsmanagementapp.model.LoginRequest
import com.eunice.billsmanagementapp.model.LoginResponse
import com.eunice.billsmanagementapp.model.RegisterRequest
import com.eunice.billsmanagementapp.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("users/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}