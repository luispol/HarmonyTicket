package com.example.harmonyticket.login.data

import com.example.harmonyticket.login.data.network.LoginService
import com.example.harmonyticket.login.data.network.response.LoginResponse
import com.example.harmonyticket.login.data.network.response.RegisterResponse

class LoginRepository {

    val api = LoginService()

    suspend fun doLogin(user:String, pass:String): LoginResponse {
      return api.doLogin(user,pass)
    }

    suspend fun register(
        username:String,
        password:String,
        name:String,
        lastname:String

    ):RegisterResponse{
        return api.register(username, password, name, lastname)
    }
}