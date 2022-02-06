package com.example.pruebatecnica.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.data.models.HeroResponse
import com.example.pruebatecnica.domain.uc.HeroUC
import kotlinx.coroutines.launch

class HeroViewModel(
    private val heroUC: HeroUC
) : ViewModel() {

//    private val job = Job()
//    private val uiScope = CoroutineScope(coroutineContextProvider.Main + job)

    val myString: String = "null"
    val myStringNull: String? = null

    fun getData() = "hola viewmodel"
    fun getDtaUseCaso() = heroUC.getDataUseCaso()

    fun getDataHero() {
        GetDataHeroState.Loading
        viewModelScope.launch {
            val result = try {
                heroUC.getDataHero()
            } catch (e: Exception) {
                Log.i("mmp", e.message ?: "No message")
            }
            val x = ""
        }
    }

    sealed class GetDataHeroState() {
        object Loading : GetDataHeroState()
        data class DataLoaded(val heroResponse: HeroResponse)
        data class Error(val message: String)
    }
}
