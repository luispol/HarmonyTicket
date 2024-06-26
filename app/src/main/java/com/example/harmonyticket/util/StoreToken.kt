package com.example.harmonyticket.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreToken(private val context:Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("MyApp")
        val TOKEN = stringPreferencesKey("token")
    }

    val getToken: Flow<String> = context.dataStore.data
        .map{ preferences ->
            preferences[TOKEN] ?: ""

        }
    suspend fun saveToken(token:String){
        context.dataStore.edit {preferences ->
            preferences[TOKEN] = token
        }
    }
}