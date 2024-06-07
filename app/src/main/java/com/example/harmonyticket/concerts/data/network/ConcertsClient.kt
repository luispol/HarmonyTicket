package com.example.harmonyticket.concerts.data.network

import com.example.harmonyticket.concerts.data.network.response.ConcertsResponse
import com.example.harmonyticket.concerts.data.network.response.ItemConcertResponse
import com.example.harmonyticket.concerts.data.network.response.OrderResponse
import com.example.harmonyticket.util.StoreToken
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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

    @POST("mytickets/saveMyTicket/{token}")
    suspend fun saveOrder(
        @Path("token") token: String,
        @Body dataJson:RequestBody
    ):Response<OrderResponse>
}

