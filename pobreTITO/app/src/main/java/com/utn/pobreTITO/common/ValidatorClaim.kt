package com.utn.pobreTITO.common

class ValidatorClaim {
    var titleError:String?=null
    var categoryError:String?=null
    var descriptionError:String?=null
    var directionError:String?=null

    fun isSuccessfully(): Boolean {
        return titleError.isNullOrEmpty() && categoryError.isNullOrEmpty() && descriptionError.isNullOrEmpty()
                && directionError.isNullOrEmpty()
    }
}