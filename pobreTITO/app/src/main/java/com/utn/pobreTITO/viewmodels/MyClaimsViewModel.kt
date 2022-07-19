package com.utn.pobreTITO.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utn.pobreTITO.database.AppDatabase
import com.utn.pobreTITO.models.Claim
import kotlinx.coroutines.launch

class MyClaimsViewModel(private val context: Context) : ViewModel(){

    var listClaim = MutableLiveData<List<Claim?>?>()

    fun getClaims(email:String){
        viewModelScope.launch {
            val database = AppDatabase.getInstance(context)
            listClaim.value = database?.claimDAO()?.getClaimForEmail(email)
        }
    }
}