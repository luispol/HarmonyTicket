package com.example.harmonyticket.login.data

import com.example.harmonyticket.login.data.network.LoginService
import com.example.harmonyticket.login.data.network.response.LoginResponse
import com.example.harmonyticket.login.data.network.response.RegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody

class LoginRepository {

    val api = LoginService()

    suspend fun doLogin(user:String, pass:String): LoginResponse {
      return api.doLogin(user,pass)
    }

    suspend fun register(
        username:RequestBody,
        password:RequestBody,
        name:RequestBody,
        lastname:RequestBody,
        photo:MultipartBody.Part? = null

    ):RegisterResponse{
        return api.register(username, password, name, lastname, photo)
    }
}