package com.example.harmonyticket.tickets.data.network.response

import com.google.gson.annotations.SerializedName

data class MyTicketsCatalog(
    @SerializedName("nombre_concierto") val nombre_concierto:String="",
    @SerializedName("nombre_cantante") val nombre_cantante:String="",
    @SerializedName("fecha") val fecha:String="",
    @SerializedName("lugar") val lugar:String=""
) {
}