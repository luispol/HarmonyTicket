package com.example.harmonyticket.util

import kotlinx.serialization.Serializable

@Serializable
data class ConcertShoppingCart (
    val id_concierto:String="",
    val nombre_concierto:String="",
    val nombre_cantante:String="",
    val fecha:String="",
    val lugar:String="",
    val precio:String="",
    val existencia:String="String",
    val genero:String="String",
    val foto:String="",
    val cantidad:Int=0
)