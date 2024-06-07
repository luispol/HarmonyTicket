package com.example.harmonyticket.tickets.data

import com.example.harmonyticket.concerts.data.network.ConcertsService
import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog
import com.example.harmonyticket.tickets.data.network.MyTicketsService
import com.example.harmonyticket.tickets.data.network.response.MyReportCatalog
import com.example.harmonyticket.tickets.data.network.response.MyTicketsCatalog

class MyTicketsRepository {

    private val api = MyTicketsService()
    suspend fun getMyTickets(token:String):List<MyTicketsCatalog>{
        return api.getMyTickets(token).data
    }

    suspend fun getReport(token:String):MyReportCatalog{
        return api.getReport(token).data
    }
}