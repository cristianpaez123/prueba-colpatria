package com.example.pruebatecnica.module

import com.example.pruebatecnica.data.repository.HeroRepositoryImp
import com.example.pruebatecnica.domain.repositories.HeroRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    factory<HeroRepository> { HeroRepositoryImp(get()) }
}
