package com.example.harmonyticket.login.data.network

import com.example.harmonyticket.core.network.RetroFitHelper
import com.example.harmonyticket.login.data.network.response.LoginResponse
import com.example.harmonyticket.login.data.network.response.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody

class LoginService {
    private val retrofit = RetroFitHelper.getRetroFit()

    suspend fun doLogin(user: String, pass: String): LoginResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java)
                .doLogin(user, pass)
            LoginResponse(
                response.body()?.success ?: false,
                response.body()?.msg ?: "",
                response.body()?.token ?: ""
            )

        }
    }
    suspend fun register(
        username: RequestBody,
        password: RequestBody,
        name: RequestBody,
        lastname: RequestBody,
        photo:MultipartBody.Part? = null

    ): RegisterResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java)
                .register(username, password, name, lastname, photo)
            RegisterResponse(
                response.body()?.success ?: false,
                response.body()?.msg ?: "",
            )
        }
    }
}
