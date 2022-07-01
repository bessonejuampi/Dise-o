package com.utn.pobreTITO

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utn.pobreTITO.databinding.ActivityLoginBinding
import com.utn.pobreTITO.viewmodels.LogInViewModel

class LogInActivity : AppCompatActivity() {

    private val viewModel : LogInActivity?=null
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = LogInViewModel(this)
        binding.btRegisterUser.setOnClickListener {
            viewModel.goToRegister()
        }

    }
}
