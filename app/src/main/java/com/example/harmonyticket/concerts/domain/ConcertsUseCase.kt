package com.example.harmonyticket.concerts.domain

import com.example.harmonyticket.concerts.data.ConcertsRepository
import com.example.harmonyticket.concerts.data.network.ConcertsService
import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog

class ConcertsUseCase {
    private val repository = ConcertsRepository()

    suspend operator fun invoke(token:String):List<ConcertsCatalog>{
        return repository.getAll(token)
    }

    suspend fun getOne(token:String, id:String):ConcertsCatalog {
        return repository.getOne(token, id)
    }
}