package com.example.pruebatecnica.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.data.models.HeroResponse
import com.example.pruebatecnica.domain.uc.HeroUC
import kotlinx.coroutines.launch

class HeroViewModel(
    private val heroUC: HeroUC
) : ViewModel() {

    private val dataHeroState: MutableLiveData<GetDataHeroState> = MutableLiveData()

    fun getDataHeroState(): LiveData<GetDataHeroState> = dataHeroState

    fun getDataHero() {
        dataHeroState.postValue(GetDataHeroState.Loading)
        viewModelScope.launch {
            try {
                val dataHero = heroUC.getDataHero()
                dataHeroState.postValue(GetDataHeroState.DataLoaded(dataHero))
            } catch (e: Exception) {
                dataHeroState.postValue(GetDataHeroState.Error("error"))
            }
        }
    }

    sealed class GetDataHeroState() {
        object Loading : GetDataHeroState()
        data class DataLoaded(val heroResponse: HeroResponse) : GetDataHeroState()
        data class Error(val message: String) : GetDataHeroState()
    }
}
