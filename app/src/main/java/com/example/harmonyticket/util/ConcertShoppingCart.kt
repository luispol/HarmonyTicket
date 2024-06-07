package com.example.harmonyticket.util
import kotlinx.serialization.Serializable


@Serializable
data class ConcertShoppingCart(
    val id_concierto:String="",
    val nombre_concierto:String="",
    val nombre_cantante:String="",
    val fecha:String="",
    val lugar:String="",
    val precio:String="",
    val existencia:String="",
    val genero:String="",
    val foto:String ="",
    val cantidad:Int=0
)

//"id_concierto": "1",
//"nombre_concierto": "Accept return",
//"nombre_cantante": "Accept",
//"fecha": "2024-06-15 00:00:00",
//"lugar": "Estadio Jorge El Magico Fonzalez",
//"precio": "78.5",
//"existencia": "40",
//"genero": "Rock",
//"foto":