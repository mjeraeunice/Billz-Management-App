package com.eunice.billsmanagementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.eunice.billsmanagementapp.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    lateinit var binding:ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}