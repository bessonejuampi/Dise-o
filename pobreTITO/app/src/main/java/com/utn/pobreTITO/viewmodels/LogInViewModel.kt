package com.utn.pobreTITO.viewmodels

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.utn.pobreTITO.HomeActivity
import com.utn.pobreTITO.R
import com.utn.pobreTITO.RegisterUserActivity
import com.utn.pobreTITO.common.DataValidator
import com.utn.pobreTITO.common.validateText
import com.utn.pobreTITO.database.AppDatabase
import kotlinx.coroutines.launch

class LogInViewModel(private val context: Context):ViewModel() {

    var dataValidationMutable = MutableLiveData<DataValidator?>()

    fun validationLogIn(email:String, pass: String){
        viewModelScope.launch {
            var dataValidator = DataValidator()
            if (!email.validateText()){
                dataValidator.emailError = context.getString(R.string.text_error)
            }
            if (!pass.validateText()){
                dataValidator.passError = context.getString(R.string.text_error)
            }
            if (dataValidator.isSuccessfully()){
                LogIn(email, pass)
            }
            dataValidationMutable.value=dataValidator
        }
    }

    fun LogIn(email:String, pass:String){
        val database = AppDatabase.getInstance(context)
        val user = database?.userDAO()?.LogIn(email, pass)
        if (user != null) {
                goToHome(email, pass)
        }else{
            Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
        }
    }

    fun VerifylogIn(){
        val prefs : SharedPreferences = context.getSharedPreferences(
            context.getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val pass = prefs.getString("pass", null)
        if (email!=null && pass!=null){
            goToHome(email, pass)
        }
    }

    fun goToRegister(){
        val intent = Intent(context, RegisterUserActivity::class.java)
        context.startActivity(intent)
    }

    fun goToHome(emial:String, pass:String){
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("email", emial)
        intent.putExtra("pass",pass)
        context.startActivity(intent)
    }

}