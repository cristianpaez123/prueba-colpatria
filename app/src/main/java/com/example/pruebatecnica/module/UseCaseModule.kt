package com.example.pruebatecnica.module

import com.example.pruebatecnica.domain.uc.HeroUC
import org.koin.dsl.module

val useCaseModule = module {
    factory { HeroUC(get()) }
}
