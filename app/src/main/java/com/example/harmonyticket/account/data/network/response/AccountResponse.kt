package com.example.harmonyticket.account.data.network.response

import com.google.gson.annotations.SerializedName

class AccountResponse(
    @SerializedName("sucess") val sucess:Boolean,
    @SerializedName("data") val data:DataProfile
) {
}