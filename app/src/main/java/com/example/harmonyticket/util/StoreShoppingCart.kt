package com.example.harmonyticket.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class StoreShoppingCart(private val context:Context ) {

    companion object{
        private val Context.dataStore:DataStore<Preferences> by preferencesDataStore("ShoppingCart")
        val CONCERTLIST = stringPreferencesKey("concertlist")
    }

    val getShoppingCart:Flow<List<ConcertShoppingCart>> =
        context.dataStore.data.map {
            preferences ->
            val concertList = preferences [CONCERTLIST] ?: ""
            if (concertList.isEmpty()){
                emptyList()
            }else{
                Json.decodeFromString<List<ConcertShoppingCart>>(concertList)
            }
        }

    suspend fun saveShoppingCart(concertList:List<ConcertShoppingCart>){
        val itemList = Json.encodeToString(concertList)
        context.dataStore.edit{
            preferences ->
            preferences[CONCERTLIST] = itemList
        }
    }
}