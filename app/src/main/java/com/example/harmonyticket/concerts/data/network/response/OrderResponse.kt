package com.example.harmonyticket.concerts.data.network.response

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class OrderResponse(
    @SerializedName("success") val success:Boolean,
    @SerializedName("message") val msg:String
) {
}