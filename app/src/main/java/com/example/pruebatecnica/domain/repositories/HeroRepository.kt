package com.example.pruebatecnica.domain.repositories

import com.example.pruebatecnica.data.models.HeroResponse

interface HeroRepository {

    suspend fun getCounters(): HeroResponse
}
