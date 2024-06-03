package com.example.harmonyticket.concerts

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog
import com.example.harmonyticket.concerts.domain.ConcertsUseCase
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemConcertViewMode(val context: Context): ViewModel() {

    val concertUseCase = ConcertsUseCase()

    private val _concert = MutableStateFlow<ConcertsCatalog>(ConcertsCatalog())
    val concert: StateFlow<ConcertsCatalog> = _concert

    val dataStore = StoreToken(context)
    val token = dataStore.getToken

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity


    fun getOneConcert(id:String){
        viewModelScope.launch {
            token.collect{
                val cr = concertUseCase.getOne(it,id)
                _concert.value = cr
            }
        }
    }

    fun setQuantity(value:Int){
        _quantity.value = if (value <= 0) {1} else { value }
    }
}