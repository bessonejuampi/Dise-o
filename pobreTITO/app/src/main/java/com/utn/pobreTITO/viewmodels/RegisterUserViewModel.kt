package com.utn.pobreTITO.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utn.pobreTITO.R
import com.utn.pobreTITO.common.DataValidator
import com.utn.pobreTITO.common.isNumber
import com.utn.pobreTITO.common.validateText
import com.utn.pobreTITO.database.AppDatabase
import com.utn.pobreTITO.models.User
import kotlinx.coroutines.launch

class RegisterUserViewModel(private val context: Context) : ViewModel() {

    var dataValidationMutable = MutableLiveData<DataValidator?>()

    fun ValidationNewUser(dni:String?, name:String?, surname:String?, pass:String?) {
        viewModelScope.launch {
            var dataValidator = DataValidator()
            if(!name.validateText()){
                dataValidator.nameError = context.getString(R.string.text_error)
            }
            if(!dni.isNumber()){
                dataValidator.dniError = context.getString(R.string.text_error)
            }
            if(!surname.validateText()){
                dataValidator.surnameError = context.getString(R.string.text_error)
            }
            if(!pass.validateText()){
                dataValidator.passError = context.getString(R.string.text_error)
            }
            if(dataValidator.isSuccessfully()){
                val user = User(dni.toString(), name.toString(), surname.toString(), pass.toString())
                RegisterNewUser(user)
            }
            dataValidationMutable.value = dataValidator
        }
    }

    fun RegisterNewUser(user: User){
        val database = AppDatabase.getInstance(context)
        database?.userDAO()?.InstertUser(user)
    }
}