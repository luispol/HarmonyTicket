package com.example.harmonyticket.concerts.data.network.response

import com.google.gson.annotations.SerializedName

data class ItemConcertResponse(
    @SerializedName("success") val success:Boolean,
    @SerializedName("data") val data:ConcertsCatalog
) {

}