package com.example.harmonyticket.login.domain

import com.example.harmonyticket.login.data.LoginRepository
import com.example.harmonyticket.login.data.network.response.LoginResponse
import com.example.harmonyticket.login.data.network.response.RegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody

class LoginUseCase {
    val repository = LoginRepository()

    suspend operator fun invoke(user:String, pass:String): LoginResponse{
        return repository.doLogin(user,pass)
    }

    suspend fun register(
        username: RequestBody,
        password:RequestBody,
        name:RequestBody,
        lastname:RequestBody,
        photo:MultipartBody.Part? = null
    ):RegisterResponse{
        return repository.register(username,password,name,lastname,photo)
    }
}