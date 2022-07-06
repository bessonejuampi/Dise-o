package com.utn.pobreTITO.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.utn.pobreTITO.R
import com.utn.pobreTITO.common.ValidatorClaim
import com.utn.pobreTITO.common.validateText
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
                registerClaim(title, category, description, direction, email_id)
            }

            validatornCalimMutable.value = validatorClaim
        }
    }

    private fun registerClaim(title:String, category:String, descrption:String, direction:String, email_id:String){
        val database = FirebaseFirestore.getInstance()
        database.collection("claim").document(email_id).set(hashMapOf(
            "title" to title,
            "category" to category,
            "description" to descrption,
            "direction" to direction)
        )
    }
}