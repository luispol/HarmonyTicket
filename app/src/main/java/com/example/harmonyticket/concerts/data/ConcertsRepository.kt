package com.example.harmonyticket.concerts.data

import com.example.harmonyticket.concerts.data.network.ConcertsService
import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog

class ConcertsRepository {
    private val api = ConcertsService()
    suspend fun getAll(token:String):List<ConcertsCatalog>{
        return api.getAll(token).data
    }

    suspend fun getOne(token:String, id:String):ConcertsCatalog{
        return api.getOne(token, id).data
    }
}