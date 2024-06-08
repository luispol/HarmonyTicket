package com.example.harmonyticket.account.data

import com.example.harmonyticket.account.data.network.AccountService
import com.example.harmonyticket.account.data.network.response.DataProfile

class AccountRepository {

    private val api = AccountService()
    suspend fun getProfile(token:String): DataProfile {
        return api.getProfile(token).data
    }
}