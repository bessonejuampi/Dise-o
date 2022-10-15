package com.utn.e_commerce.di

import com.utn.e_commerce.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        val baseUrl = "http://testing.nexoserver.com.ar/bootcampmobile/" //TODO:PONER URL DE LAUTI
        return Retrofit.Builder()
            .baseUrl(baseUrl) //TODO:poner url de lauti en cont y agregar
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideHttpClinet())
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpClinet() : OkHttpClient{
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        return httpClient
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit : Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }
}