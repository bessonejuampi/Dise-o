package com.utn.pobreTITO

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.utn.pobreTITO.databinding.ActivityRegisterUserBinding
import com.utn.pobreTITO.viewmodels.RegisterUserViewModel


class RegisterUserActivity : AppCompatActivity() {

    private var viewModel : RegisterUserViewModel? = null
    private lateinit var binding : ActivityRegisterUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = RegisterUserViewModel(this)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        binding.btRegister.setOnClickListener {
            viewModel!!.ValidationNewUser(
                binding.tfEmail.editText?.text.toString(),
                binding.etName.text.toString(),
                binding.etSurname.text.toString(),
                binding.etPass.text.toString()
            )
        }
        setupViewModelObserver()
        setupEditText()
    }

    private fun setupViewModelObserver() {
        viewModel?.dataValidationMutable?.observe(this, Observer { dataValidation -> dataValidation?.let {
            if(!dataValidation.emailError.isNullOrEmpty()){
                binding.tfEmail.error = dataValidation.emailError
            }
            if(!dataValidation.nameError.isNullOrEmpty()){
                binding.tfName.error = dataValidation.nameError
            }
            if(!dataValidation.surnameError.isNullOrEmpty()){
                binding.tfSurname.error = dataValidation.surnameError
            }
            if(!dataValidation.passError.isNullOrEmpty()){
                binding.tfPass.error = dataValidation.passError
            }
        }
        })
    }

    private fun setupEditText() {
        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfName.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
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
        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfName.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
        binding.etSurname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfSurname.error = null
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) { onBackPressed() }
        return super.onOptionsItemSelected(item)
    }
}