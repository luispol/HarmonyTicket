package com.example.harmonyticket.concerts.data.network

import com.example.harmonyticket.concerts.data.network.response.ConcertsResponse
import com.example.harmonyticket.concerts.data.network.response.ItemConcertResponse
import com.example.harmonyticket.concerts.data.network.response.OrderResponse
import com.example.harmonyticket.core.network.RetroFitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
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

    /*suspend fun saveOrder(token:String, dataJson:RequestBody):OrderResponse{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ConcertsClient::class.java).saveOrder(token, dataJson)
            OrderResponse(
                response.body()?.success ?: false,
                response.body()?.msg ?: ""
            )


        }
    }*/

    suspend fun saveOrder(token: String, idConcert: String): OrderResponse {
        return withContext(Dispatchers.IO) {
            val requestBody = idConcert.toRequestBody("text/plain".toMediaTypeOrNull())
            val response = retrofit.create(ConcertsClient::class.java).saveOrder(token, requestBody)
            OrderResponse(
                response.body()?.success ?: false,
                response.body()?.msg ?: ""
            )
        }
    }




}