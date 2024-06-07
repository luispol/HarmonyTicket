package com.example.harmonyticket.concerts

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog
import com.example.harmonyticket.concerts.domain.ConcertsUseCase
import com.example.harmonyticket.util.ConcertShoppingCart
import com.example.harmonyticket.util.StoreShoppingCart
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemConcertsViewModel(val context: Context): ViewModel() {


        val concertUseCase = ConcertsUseCase()

        private val _concert = MutableStateFlow<ConcertsCatalog>(ConcertsCatalog())
        val concert: StateFlow<ConcertsCatalog> = _concert

        val dataStore = StoreToken(context)
        val token = dataStore.getToken

        val dataShoppingCart = StoreShoppingCart(context)
        val itemList = dataShoppingCart.getShoppingCart


        private val _quantity = MutableLiveData<Int>()
        val quantity: LiveData<Int> = _quantity

        private val _listConcertShippingCart = MutableLiveData<List<ConcertShoppingCart>>(emptyList())


        fun getOneConcert(id:String){
            viewModelScope.launch {
                token.collect{
                    val cr = concertUseCase.getOne(it,id)
                    _concert.value = cr
                    itemList.collect{listConcert->
                        _listConcertShippingCart.value = listConcert
                    }
                }
            }
        }

        fun setQuantity(value:Int){
            _quantity.value = if (value <= 0) {1} else { value }
        }

        fun saveShoppingCart(concert: ConcertShoppingCart){
            viewModelScope.launch {
                val listAdd = _listConcertShippingCart.value?.toMutableList()
                listAdd?.add(concert)
                dataShoppingCart.saveShoppingCart(listAdd?.toList() ?: emptyList())
            }
        }

    }
