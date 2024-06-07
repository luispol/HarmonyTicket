package com.example.harmonyticket.account.domain

import com.example.harmonyticket.account.data.AccountRepository
import com.example.harmonyticket.account.data.network.response.DataProfile

class AccountUseCase {

    private val repository = AccountRepository()
    suspend operator fun invoke(token:String): DataProfile {
        return repository.getProfile(token)
    }
}