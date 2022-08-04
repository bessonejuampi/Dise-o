package com.utn.pobreTITO.viewmodels

import android.content.Context
import android.content.Intent
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utn.pobreTITO.HomeActivity
import com.utn.pobreTITO.R
import com.utn.pobreTITO.common.DataValidator
import com.utn.pobreTITO.common.validateText
import com.utn.pobreTITO.database.AppDatabase
import com.utn.pobreTITO.models.User
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class RegisterUserViewModel(private val context: Context) : ViewModel() {

    var dataValidationMutable = MutableLiveData<DataValidator?>()

    fun ValidationNewUser(email:String?, name:String?, surname:String?, pass:String?, dni : String) {
        viewModelScope.launch {
            var dataValidator = DataValidator()
            if(!name.validateText()){
                dataValidator.nameError = context.getString(R.string.text_error)
            }
            if(validateEmail(email!!)){
                dataValidator.emailError = context.getString(R.string.text_error)
            }
            if(!surname.validateText()){
                dataValidator.surnameError = context.getString(R.string.text_error)
            }
            if(!pass.validateText()){
                dataValidator.passError = context.getString(R.string.text_error)
            }

            if(!dni.validateText()){
                dataValidator.dniError = context.getString(R.string.text_error)
            }
            if(dataValidator.isSuccessfully()){
                RegisterNewUser(email.toString(), name.toString(), surname.toString(), pass.toString(), dni)
            }
            dataValidationMutable.value = dataValidator
        }
    }

    fun validateEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return !pattern.matcher(email).matches()
    }

    private fun RegisterNewUser(email:String, name: String, surname: String, pass:String, dni: String){
        val database = AppDatabase.getInstance(context)
        database?.userDAO()?.InsertUser(User(dni, name, surname, pass, email))
        goToHome(email, pass)
    }

    private fun goToHome(email: String, pass: String){
        val intent = Intent(context, HomeActivity::class.java)
        intent.putExtra("email", email)
        intent.putExtra("pass",pass)
        context.startActivity(intent)
    }

}