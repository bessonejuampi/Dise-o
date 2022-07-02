package com.utn.pobreTITO.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.utn.pobreTITO.R

class HomeViewModel(private val context: Context) : ViewModel() {

    fun signOutUser(){
        FirebaseAuth.getInstance().signOut()
        val prefs : SharedPreferences.Editor = context.getSharedPreferences(
            context.getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.clear()
        prefs.apply()
    }

    fun saveSession(emial:String, pass:String){
        val prefs : SharedPreferences.Editor = context.getSharedPreferences(
            context.getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email", emial)
        prefs.putString("pass", pass)
        prefs.apply()
    }
}