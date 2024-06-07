package com.example.harmonyticket.tickets.data.network

import com.example.harmonyticket.concerts.data.network.response.ConcertsResponse
import com.example.harmonyticket.tickets.data.network.response.TicketResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MyTicketsClient {

    @GET("mytickets/getMyTickets/{token}")
    suspend fun getMyTickets(
        @Path("token") token:String
    ): Response<TicketResponse>
}