package com.example.harmonyticket.tickets.data.network.response

import com.google.gson.annotations.SerializedName

data class MyReportCatalog(
    @SerializedName("file") val file:String="",
) {
}