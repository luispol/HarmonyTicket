package com.example.harmonyticket.tickets.data.network.response

import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog
import com.google.gson.annotations.SerializedName

data class TicketResponse (
    @SerializedName("success") val success:Boolean,
    @SerializedName("data") val data:List<MyTicketsCatalog>
){
}