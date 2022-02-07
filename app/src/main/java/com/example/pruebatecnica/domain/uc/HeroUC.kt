package com.example.pruebatecnica.domain.uc

import com.example.pruebatecnica.domain.repositories.HeroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroUC(private val heroRepository: HeroRepository) {

    suspend fun getDataHero() = withContext(Dispatchers.IO) { heroRepository.getHeros() }
}
