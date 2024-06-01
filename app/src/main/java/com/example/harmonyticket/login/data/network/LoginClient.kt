package com.example.harmonyticket.login.data.network

import com.example.harmonyticket.login.data.network.response.LoginResponse
import com.example.harmonyticket.login.data.network.response.RegisterResponse
import retrofit2.Response

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginClient {
    @POST("usuarios/login")
    @FormUrlEncoded
    suspend fun doLogin(
        @Field("user") user:String,
        @Field("pass") pass:String
    ): Response<LoginResponse>

    @POST("usuarios/register")
    @FormUrlEncoded
    suspend fun register(
        @Field("username") username:String,
        @Field("password") password:String,
        @Field("name") name:String,
        @Field("lastname") lastname:String,
    ):Response<RegisterResponse>

}