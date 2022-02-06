package com.example.pruebatecnica.data.networkEndPoints

import com.example.pruebatecnica.data.models.HeroResponse
import retrofit2.http.GET

interface HeroApi {
    @GET("characters?ts=1&apikey=dc4a38ca2f58c9540c5a1aa198dbc667&hash=b802431b1b0c2a87b19ed16616d11535")
    suspend fun getHero(): HeroResponse
}
