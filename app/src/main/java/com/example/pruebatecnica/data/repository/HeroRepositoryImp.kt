package com.example.pruebatecnica.data.repository

import com.example.pruebatecnica.data.models.Results
import com.example.pruebatecnica.data.networkEndPoints.HeroApi
import com.example.pruebatecnica.domain.repositories.HeroRepository

class HeroRepositoryImp(private val heroApi: HeroApi) : HeroRepository {
    override suspend fun getHeros(): List<Results> = heroApi.getHero().data.results
}
