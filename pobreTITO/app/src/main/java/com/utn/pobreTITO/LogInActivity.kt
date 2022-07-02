package com.utn.pobreTITO

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseAuth
import com.utn.pobreTITO.databinding.ActivityLoginBinding
import com.utn.pobreTITO.viewmodels.LogInViewModel

class LogInActivity : AppCompatActivity() {

    private var viewModel : LogInViewModel?=null
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel = LogInViewModel(this)
        binding.btRegisterUser.setOnClickListener {
            viewModel!!.goToRegister()
        }

        binding.btLogIn.setOnClickListener {
            viewModel!!.validationLogIn(
                binding.etEmail.text.toString(),
                binding.etPass.text.toString()
            )
        }

        setupViewModelObserver()
        setupEditText()

        viewModel!!.VerifylogIn()

    }

    private fun setupViewModelObserver() {
        viewModel?.dataValidationMutable?.observe(this, Observer { dataValidation -> dataValidation?.let {
            if(!dataValidation.emailError.isNullOrEmpty()){
                binding.tfEmail.error = dataValidation.emailError
            }
            if(!dataValidation.passError.isNullOrEmpty()){
                binding.tfPass.error = dataValidation.passError
            }
        }
        })
    }

    private fun setupEditText() {

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfEmail.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })

        binding.etPass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfPass.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
    }


}
