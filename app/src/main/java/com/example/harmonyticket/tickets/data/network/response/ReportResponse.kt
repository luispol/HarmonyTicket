package com.example.harmonyticket.tickets.data.network.response

import com.google.gson.annotations.SerializedName

data class ReportResponse(
    @SerializedName("success") val success:Boolean,
    @SerializedName("data") val data:MyReportCatalog


) {

}