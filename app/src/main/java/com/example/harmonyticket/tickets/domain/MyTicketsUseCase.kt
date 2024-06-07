package com.example.harmonyticket.tickets.domain

import com.example.harmonyticket.concerts.data.ConcertsRepository
import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog
import com.example.harmonyticket.tickets.data.MyTicketsRepository
import com.example.harmonyticket.tickets.data.network.response.MyTicketsCatalog

class MyTicketsUseCase {
    private val repository = MyTicketsRepository()

    suspend operator fun invoke(token:String):List<MyTicketsCatalog>{
        return repository.getMyTickets(token)
    }
}