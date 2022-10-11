package com.utn.e_commerce.data.model

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("dni") var dni : String, //TODO: VER COMO VUELVE DE BACKEND Y PONER EL NOMBRE CORRECTO DE SEREALIZED
    @SerializedName("name") var name : String,
    @SerializedName("last_name") var lastName : String,
    @SerializedName("date_birth") var dateBirth : String,
    @SerializedName("address") var address : String,
    @SerializedName("phone_numbre") var phoneNumber  : String
) {
}