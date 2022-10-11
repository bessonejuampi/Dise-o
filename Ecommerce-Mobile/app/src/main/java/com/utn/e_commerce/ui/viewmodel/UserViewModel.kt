package com.utn.e_commerce.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.utn.e_commerce.data.model.User

class UserViewModel : ViewModel(){

    val user = MutableLiveData<User>()
}