package com.example.harmonyticket.concerts

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog
import com.example.harmonyticket.concerts.domain.ConcertsUseCase
import com.example.harmonyticket.util.StoreShoppingCart
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ConcertsViewModel(val context: Context): ViewModel() {

    val dataStore = StoreToken(context)
    val token = dataStore.getToken
    val dataShoppingCart = StoreShoppingCart(context)
    val itemList = dataShoppingCart.getShoppingCart
    private val _totalItems=MutableLiveData<Int>()
    val totalItems:LiveData<Int> = _totalItems
    val concertsUseCase = ConcertsUseCase()

    private val _concerts = MutableStateFlow<List<ConcertsCatalog>>(emptyList())
    val concerts:StateFlow<List<ConcertsCatalog>> = _concerts


    fun loadData() {
        viewModelScope.launch {
            token.collect{
                val concerts = concertsUseCase(it)
                addConcerts(concerts)
            }
        }
    }

    fun addConcerts(concerts:List<ConcertsCatalog>){
        _concerts.value = concerts
    }

    fun getTotalItems(){

    }


}