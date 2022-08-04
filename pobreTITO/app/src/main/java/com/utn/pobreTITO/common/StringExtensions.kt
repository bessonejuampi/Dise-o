package com.utn.pobreTITO.common

import android.util.Patterns
import java.util.regex.Pattern


fun String?.isNumber(): Boolean {
    return if (this.isNullOrEmpty()) {
        false
    } else {
        try {
            this.toDouble() // Si llega a esta punto y no puede convertirlo a un numero significa
            // que habia caracteres en el string, entoces retorna un false
            true
        } catch (e: Exception) {
            false
        }
    }
}
fun String?.validateText(): Boolean {
    return !this.isNullOrEmpty()
}

