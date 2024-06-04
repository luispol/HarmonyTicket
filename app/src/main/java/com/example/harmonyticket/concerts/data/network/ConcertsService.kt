package com.example.harmonyticket.concerts.data.network

import com.example.harmonyticket.concerts.data.network.response.ConcertsResponse
import com.example.harmonyticket.concerts.data.network.response.ItemConcertResponse
import com.example.harmonyticket.core.network.RetroFitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class ConcertsService {

    private val retrofit = RetroFitHelper.getRetroFit()
    suspend fun getAll(token:String):ConcertsResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ConcertsClient::class.java).getAll(token)
            ConcertsResponse(
                response.body()?.success ?: false,
                response.body()!!.data)
        }
    }

    suspend fun getOne(token:String, id:String):ItemConcertResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ConcertsClient::class.java).getOne(token, id)
            ItemConcertResponse(
                response.body()?.success ?: false,
                response.body()!!.data
            )

        }
    }

}