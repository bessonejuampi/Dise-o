package com.utn.e_commerce.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.utn.e_commerce.databinding.ActivityLogInBinding
import com.utn.e_commerce.ui.viewmodel.UserViewModel

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private val userViewModel : UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}