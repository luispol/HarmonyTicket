package com.example.harmonyticket.tickets.data.network

import com.example.harmonyticket.concerts.data.network.ConcertsClient
import com.example.harmonyticket.concerts.data.network.response.ConcertsResponse
import com.example.harmonyticket.core.network.RetroFitHelper
import com.example.harmonyticket.tickets.data.network.response.ReportResponse
import com.example.harmonyticket.tickets.data.network.response.TicketResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyTicketsService {
    private val retrofit = RetroFitHelper.getRetroFit()

    suspend fun getMyTickets(token:String): TicketResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(MyTicketsClient::class.java).getMyTickets(token)
            TicketResponse(
                response.body()?.success ?: false,
                response.body()!!.data)
        }
    }

    suspend fun getReport(token: String): ReportResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(MyTicketsClient::class.java).getReport(token)
            ReportResponse(response.body()?.success ?: false, response.body()!!.data)
        }
    }
}