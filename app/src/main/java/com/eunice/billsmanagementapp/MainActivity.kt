package com.eunice.billsmanagementapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunice.billsmanagementapp.Utils.Constants
import com.eunice.billsmanagementapp.databinding.ActivityMainBinding

class MainActivity:AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        redirectUser()
    }

    override fun onResume() {
        super.onResume()
        binding.btnGetStarted.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)

        }
    }
    fun redirectUser(){
        val prefs=getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)
        val userId=prefs.getString(Constants.USER_ID,Constants.EMPTY_STRING)
        if (userId != null) {
            if(userId.isNotBlank()){
                startActivity(Intent(this,Login::class.java))
            } else{
                startActivity(Intent(this,HomePage::class.java))
            }
        }
        }
    }
//can use !! instead of if (userId != null)