package com.example.harmonyticket.concerts.data.network.response

import com.google.gson.annotations.SerializedName

data class ConcertsResponse(
    @SerializedName("success") val success:Boolean,
    @SerializedName("data") val data:List<ConcertsCatalog>
) {
}