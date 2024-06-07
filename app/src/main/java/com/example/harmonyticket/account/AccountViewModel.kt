package com.example.harmonyticket.account

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harmonyticket.account.data.network.response.DataProfile
import com.example.harmonyticket.account.domain.AccountUseCase
import com.example.harmonyticket.util.StoreToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AccountViewModel(val context: Context): ViewModel() {

    val accountUseCase = AccountUseCase()

    val dataStore = StoreToken(context)
    val token = dataStore.getToken

    private val _profile = MutableStateFlow<DataProfile>(DataProfile())
    val profile: StateFlow<DataProfile> = _profile


    fun loadData() {
        viewModelScope.launch {
            token.collect {
                val profile = accountUseCase(it)
                addProfile(profile)
            }
        }
    }

    fun addProfile(profile: DataProfile) {
        _profile.value = profile
    }
}