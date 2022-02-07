package com.example.pruebatecnica.domain.repositories

import com.example.pruebatecnica.data.models.Results

interface HeroRepository {

    suspend fun getHeros(): List<Results>
}
