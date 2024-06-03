package com.example.harmonyticket.concerts.data.network

import com.example.harmonyticket.concerts.data.network.response.ConcertsResponse
import com.example.harmonyticket.concerts.data.network.response.ItemConcertResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ConcertsClient {

    @GET("conciertos/getConcerts/{token}")
    suspend fun getAll(
        @Path("token") token:String
    ): Response<ConcertsResponse>

    @GET("conciertos/getOneConcert/{token}")
    suspend fun getOne(
        @Path("token") token:String,
        @Query("id") id:String
    ):Response<ItemConcertResponse>
}

