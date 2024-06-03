package com.example.harmonyticket.concerts.data.network.response

import com.google.gson.annotations.SerializedName

class ConcertsCatalog(
    @SerializedName("id_concierto") val id_concert:String="",
    @SerializedName("nombre_concierto") val nombre_concierto:String="",
    @SerializedName("nombre_cantante") val nombre_cantante:String="",
    @SerializedName("fecha") val fecha:String="",
    @SerializedName("precio") val precio:String="0",
    @SerializedName("existencia") val existencia:String="",
    @SerializedName("id_genero") val id_genero:String="",
    @SerializedName("foto") val foto:String=""
) {
}