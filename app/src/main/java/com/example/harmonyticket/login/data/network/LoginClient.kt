package com.example.harmonyticket.login.data.network

import com.example.harmonyticket.login.data.network.response.LoginResponse
import com.example.harmonyticket.login.data.network.response.RegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface LoginClient {
    @POST("usuarios/login")
    @FormUrlEncoded
    suspend fun doLogin(
        @Field("user") user:String,
        @Field("pass") pass:String
    ): Response<LoginResponse>

    @POST("usuarios/register")
    @Multipart
    suspend fun register(
        @Part("username") username: RequestBody,
        @Part("password") password:RequestBody,
        @Part("name") name:RequestBody,
        @Part("lastname") lastname:RequestBody,
        @Part photo: MultipartBody.Part? = null
    ):Response<RegisterResponse>

}