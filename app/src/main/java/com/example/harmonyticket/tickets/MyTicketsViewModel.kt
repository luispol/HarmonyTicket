package com.example.harmonyticket.tickets

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harmonyticket.concerts.data.network.response.ConcertsCatalog
import com.example.harmonyticket.concerts.domain.ConcertsUseCase
import com.example.harmonyticket.tickets.data.network.response.MyTicketsCatalog
import com.example.harmonyticket.tickets.domain.MyTicketsUseCase
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyTicketsViewModel(val context: Context): ViewModel() {
    val dataStore = StoreToken(context)
    val token = dataStore.getToken

    val myTicketsUseCase = MyTicketsUseCase()


    private val _myTickets = MutableStateFlow<List<MyTicketsCatalog>>(emptyList())
    val myTickets: StateFlow<List<MyTicketsCatalog>> = _myTickets

    fun loadData() {
        viewModelScope.launch {
            token.collect{
                val myTickets = myTicketsUseCase(it)
                addMyTickets(myTickets)
            }
        }
    }

    fun addMyTickets(myTickets:List<MyTicketsCatalog>){
        _myTickets.value = myTickets
    }
}