package com.chidi.funfact

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chidi.funfact.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null

    private var usernameOrEmail: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        handleOnClickEvents()
    }

    private fun handleOnClickEvents() {
        binding?.btnLogIn?.setOnClickListener {
            if (isValid()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish();
            }
        }
    }

    /**
     *  Validate input fields and the login details
     */
    private fun isValid(): Boolean {
        usernameOrEmail = binding?.emailField?.text.toString()
        password = binding?.passwordField?.text.toString()

        if (usernameOrEmail.isNullOrEmpty()) {
            binding?.emailField?.error = "required"
            return false
        }
        if (password.isNullOrEmpty()) {
            binding?.passwordField?.error = "required"
            return false
        }

        if (!password.equals(LoginDetails.LOGIN_PASSWORD)) {
            binding?.passwordField?.error = "Incorrect password"
            return false
        }

        if (!usernameOrEmail.equals(LoginDetails.LOGIN_EMAIL)) {
            binding?.emailField?.error = "Account not found!"
            return false
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}