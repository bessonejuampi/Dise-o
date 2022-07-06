package com.utn.pobreTITO.viewmodels

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.utn.pobreTITO.R
import com.utn.pobreTITO.RegisterClaimActivity

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

    fun goToRegisterClaim(){
        val intent = Intent(context, RegisterClaimActivity::class.java)
        val prefs : SharedPreferences = context.getSharedPreferences(context.getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        intent.putExtra("email", email)
        context.startActivity(intent)
    }


}