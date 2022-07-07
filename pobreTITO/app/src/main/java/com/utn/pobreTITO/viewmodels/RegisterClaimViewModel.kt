package com.utn.pobreTITO.viewmodels

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.utn.pobreTITO.HomeActivity
import com.utn.pobreTITO.R
import com.utn.pobreTITO.common.EnumCodition
import com.utn.pobreTITO.common.ValidatorClaim
import com.utn.pobreTITO.common.validateText
import com.utn.pobreTITO.database.AppDatabase
import com.utn.pobreTITO.models.Claim
import kotlinx.coroutines.launch

class RegisterClaimViewModel(private val context : Context) : ViewModel() {

    var validatornCalimMutable = MutableLiveData<ValidatorClaim?>()

    fun ValidationRegisterClaim(title:String, category:String, description:String, direction:String, email_id:String){
        viewModelScope.launch {
            var validatorClaim = ValidatorClaim()
            if(!title.validateText()){
                validatorClaim.titleError = context.getString(R.string.text_error)
            }
            if(!category.validateText()){
                validatorClaim.categoryError = context.getString(R.string.text_error)
            }
            if(!description.validateText()){
                validatorClaim.descriptionError = context.getString(R.string.text_error)
            }
            if(!direction.validateText()){
                validatorClaim.directionError = context.getString(R.string.text_error)
            }
            if (validatorClaim.isSuccessfully()){
                val claim = Claim(title, category, description, direction, EnumCodition.ENVIADA.toString(), email_id)
                registerClaim(claim)
                Toast.makeText(context, "¡Reclamo registrado!", Toast.LENGTH_SHORT).show()
                goToHome()
            }

            validatornCalimMutable.value = validatorClaim
        }
    }

    private fun registerClaim(claim: Claim){
        val database = AppDatabase.getInstance(context)
        database?.claimDAO()?.InsertClaim(claim)
    }

    private fun goToHome(){
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }
}