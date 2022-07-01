package com.utn.pobreTITO.viewmodels

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.utn.pobreTITO.RegisterUserActivity

class LogInViewModel(private val context: Context):ViewModel() {
    fun goToRegister(){
        val intent = Intent(context, RegisterUserActivity::class.java)
        context.startActivity(intent)
    }
}