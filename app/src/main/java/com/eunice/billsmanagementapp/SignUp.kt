package com.eunice.billsmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunice.billsmanagementapp.databinding.ActivitySignUpBinding
import com.eunice.billsmanagementapp.model.RegisterRequest
import com.eunice.billsmanagementapp.model.RegisterResponse
import com.eunice.billsmanagementapp.viewmodel.UserViewModel

class SignUp : AppCompatActivity() {
    val userViewModel: UserViewModel by viewModels()
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener{
            clearErrors()
            validateSignUp()
        }
        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            Toast.makeText(this,regResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(this,Login::class.java))
            binding.pbRegister.visibility=View.GONE
        })
        userViewModel.regLiveData.observe(this, Observer { err ->
            Toast.makeText(this,err.message,Toast.LENGTH_LONG).show()
            binding.pbRegister.visibility=View.GONE
    })
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }
    }

    fun validateSignUp() {
        val firstName=binding.etFirstname.text.toString()
        val lastName=binding.etLastName.text.toString()
        val phoneNumber=binding.etPhonenumber.text.toString()
        val email = binding.etPassword2.text.toString()
        val password = binding.etPassword.text.toString()
        val confirm=binding.etConfirmpassword.text.toString()
        var error = false

        if (firstName.isBlank()) {
            error = true
            binding.tilUsername.error = "First name is required"
        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "First name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilPassword2.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhonenumber.error = "Your phone number is required"
            error = true
        }
        if(!error){
            val registerRequest=RegisterRequest(
                firstName =firstName,
                lastName = lastName,
                email=email,
                phonenumber = phoneNumber,
                password = password,
            )
            userViewModel.registerUser(registerRequest)
            Toast.makeText(this,"Registration of $firstName" +
                    " was sucessful",
                Toast.LENGTH_LONG).show()
        }
    }

    fun clearErrors() {
        binding.tilUsername.error = null
        binding.tilLastName
        binding.tilPassword2.error = null
        binding.tilPassword.error = null
        binding.tilPhonenumber.error = null
        binding.tilConfirmpassword.error=null
    }
}


