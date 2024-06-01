package com.example.harmonyticket.login.data.network.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("success") val success:Boolean,
    @SerializedName("msg") val msg:String) {
}