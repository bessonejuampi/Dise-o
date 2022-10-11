package com.utn.e_commerce.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private var API_SERVICE: ApiService? = null

    fun getApiService(): ApiService? {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        val baseUrl = "http://testing.nexoserver.com.ar/bootcampmobile/" //TODO:PONER URL DE LAUTI
        if (API_SERVICE == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
            API_SERVICE = retrofit.create(ApiService::class.java)
        }
        return API_SERVICE
    }
}