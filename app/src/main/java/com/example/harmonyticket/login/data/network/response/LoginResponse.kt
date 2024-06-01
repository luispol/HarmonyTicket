package com.example.harmonyticket.login.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success") val success:Boolean,
    @SerializedName("msg") val msg:String,
    @SerializedName("token") val token:String){

}


