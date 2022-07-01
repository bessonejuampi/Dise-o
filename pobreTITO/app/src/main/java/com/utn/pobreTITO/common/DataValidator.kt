package com.utn.pobreTITO.common

class DataValidator {
    var dniError : String? = null
    var nameError : String? = null
    var surnameError: String? = null
    var passError : String? = null

    fun isSuccessfully(): Boolean {
        return nameError.isNullOrEmpty() && dniError.isNullOrEmpty() && surnameError.isNullOrEmpty()
                && passError.isNullOrEmpty()
    }
}