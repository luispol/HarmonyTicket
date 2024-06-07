package com.example.harmonyticket.account.data.network

import com.example.harmonyticket.account.data.network.response.AccountResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountClient {

    @GET("usuarios/getProfile/{token}")

    suspend fun getProfile(
        @Path("token") token:String

    ): Response<AccountResponse>
}