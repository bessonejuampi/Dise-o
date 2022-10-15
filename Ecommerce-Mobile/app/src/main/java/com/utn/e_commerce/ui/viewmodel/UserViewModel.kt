package com.utn.e_commerce.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.utn.e_commerce.data.model.User
import com.utn.e_commerce.data.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val api : ApiService
): ViewModel() {


    val user = MutableLiveData<User>()


    private fun getUser(){

    }
}