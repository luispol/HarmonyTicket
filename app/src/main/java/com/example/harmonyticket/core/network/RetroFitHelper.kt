package com.example.harmonyticket.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {

    fun getRetroFit(): Retrofit {
        return Retrofit.Builder()
            //.baseUrl("http://35.222.240.229/apiproyecto/v1.0/")
            .baseUrl("http://192.168.56.101/apiproyecto/v1.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}