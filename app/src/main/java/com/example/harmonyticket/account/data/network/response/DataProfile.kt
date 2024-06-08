package com.example.harmonyticket.account.data.network.response

import com.google.gson.annotations.SerializedName

data class DataProfile(
    @SerializedName("username") val username:String="",
    @SerializedName("nombres") val nombres:String="",
    @SerializedName("apellidos") val apellidos:String="",
    @SerializedName("foto") val foto:String=""
) {
}