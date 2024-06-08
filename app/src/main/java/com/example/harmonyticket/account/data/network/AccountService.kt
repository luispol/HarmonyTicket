package com.example.harmonyticket.account.data.network

import com.example.harmonyticket.account.data.network.response.AccountResponse
import com.example.harmonyticket.core.network.RetroFitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountService {
    private val retrofit = RetroFitHelper.getRetroFit()
    suspend fun getProfile(token:String): AccountResponse {
        return withContext(Dispatchers.IO){

            val response =  retrofit.create(AccountClient::class.java).getProfile(token)
            AccountResponse(response.body()?.sucess?:false, response.body()!!.data)
        }
    }
}