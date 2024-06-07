package com.example.harmonyticket.concerts.data.network.response

import com.google.gson.annotations.SerializedName

data class ConcertsCatalog(
    @SerializedName("id_concierto") val id_concert:String="",
    @SerializedName("nombre_concierto") val nombre_concierto:String="",
    @SerializedName("nombre_cantante") val nombre_cantante:String="",
    @SerializedName("fecha") val fecha:String="",
    @SerializedName("lugar") val lugar:String="",
    @SerializedName("precio") val precio:String="0",
    @SerializedName("existencia") val existencia:String="",
    @SerializedName("genero") val genero:String="",
    @SerializedName("foto") val foto:String=""
) {
}


//"id_concierto": "1",
//"nombre_concierto": "Accept return",
//"nombre_cantante": "Accept",
//"fecha": "2024-06-15 00:00:00",
//"lugar": "Estadio Jorge El Magico Fonzalez",
//"precio": "78.5",
//"existencia": "40",
//"genero": "Rock",
//"foto":