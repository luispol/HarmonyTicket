package com.example.harmonyticket.concerts

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harmonyticket.concerts.domain.ConcertsUseCase
import com.example.harmonyticket.util.ConcertShoppingCart
import com.example.harmonyticket.util.StoreShoppingCart
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody


class ShoppingCartViewModel(val context:Context): ViewModel() {

    val dataShoppingCart = StoreShoppingCart(context)
    val itemsList = dataShoppingCart.getShoppingCart

    private val _listConcertShoppingCart = MutableLiveData<List<ConcertShoppingCart>>(emptyList())
    val listConcertShoppingCart: LiveData<List<ConcertShoppingCart>> = _listConcertShoppingCart

    val concertsUseCase = ConcertsUseCase()

    val dataStore = StoreToken(context)
    val token = dataStore.getToken

//        private val _listConcertShoppingCart = MutableLiveData<List<ConcertShoppingCart>>(emptyList())
//        val listConcertShoppingCart: LiveData<List<ConcertShoppingCart>> = _listConcertShoppingCart


    init {
        viewModelScope.launch {
            itemsList.collect { listConcert ->
                _listConcertShoppingCart.value = listConcert

            }
        }
    }

    fun saveOrder() {
        viewModelScope.launch {
            token.collect {
                val items = Json.encodeToString(_listConcertShoppingCart.value)
                val json = items.toRequestBody("application/json".toMediaTypeOrNull())
                val result = concertsUseCase.saveOrder(it, json)
                Toast.makeText(context, result.msg, Toast.LENGTH_LONG).show()
                dataShoppingCart.saveShoppingCart(emptyList())
            }
        }
    }
    fun clean(){
        viewModelScope.launch {
            _listConcertShoppingCart.value = emptyList()
            dataShoppingCart.saveShoppingCart(emptyList())
        }

    }
}




