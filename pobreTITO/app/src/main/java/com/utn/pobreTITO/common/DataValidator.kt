package com.utn.pobreTITO.common

class DataValidator {
    var emailError : String? = null
    var nameError : String? = null
    var surnameError: String? = null
    var passError : String? = null

    fun isSuccessfully(): Boolean {
        return nameError.isNullOrEmpty() && emailError.isNullOrEmpty() && surnameError.isNullOrEmpty()
                && passError.isNullOrEmpty()
    }
}