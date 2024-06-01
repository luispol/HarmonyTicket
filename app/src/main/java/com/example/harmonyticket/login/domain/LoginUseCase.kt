package com.example.harmonyticket.login.domain

import com.example.harmonyticket.login.data.LoginRepository
import com.example.harmonyticket.login.data.network.response.LoginResponse
import com.example.harmonyticket.login.data.network.response.RegisterResponse

class LoginUseCase {
    val repository = LoginRepository()

    suspend operator fun invoke(user:String, pass:String): LoginResponse{
        return repository.doLogin(user,pass)
    }

    suspend fun register(username:String, password:String, name:String, lastname:String):RegisterResponse{
        return repository.register(username,password,name,lastname)
    }
}