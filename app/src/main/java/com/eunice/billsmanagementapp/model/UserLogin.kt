package com.eunice.billsmanagementapp.model

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("user_id") var userId: String,
    val email:String,
    var password:String,
)
