package com.eunice.billsmanagementapp
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.eunice.billsmanagementapp.databinding.ActivityLoginBinding
import com.eunice.billsmanagementapp.model.LoginRequest
import com.eunice.billsmanagementapp.viewmodel.LoginViewModel


class Login : AppCompatActivity() {
    val loginViewModel:LoginViewModel by viewModels()
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener{
            clearErrors()
            validateLogin()
        }
        loginViewModel.logLiveData.observe(this, Observer { logResponse ->
            Toast.makeText(this,logResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this,HomePage::class.java))
        })
        loginViewModel.logLiveData.observe(this, Observer { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })
        binding.tvSign.setOnClickListener {
            startActivity(Intent(this,HomePage::class.java))
        }
    }

    fun validateLogin() {
        val email=binding.etUsersname.text.toString()
        val password = binding.etpassWord.text.toString()

        var error = false

        if (email.isBlank()) {
            error = true
            binding.tilUsersname.error = "First name is required"
        }
        if (password.isBlank()) {
            binding.tilpassWord.error = "Password is required"
            error = true
        }
        if(!error){
            val loginRequest=LoginRequest(
              email=email,
                password = password,
            )
            loginViewModel.loginUser(loginRequest)
            Toast.makeText(this,"login was successful",
                Toast.LENGTH_LONG).show()
        }
    }

    fun clearErrors() {
        binding.tilUsersname.error = null
        binding.tilpassWord.error = null
    }
}
