package com.example.pruebatecnica.module

import com.example.pruebatecnica.presentation.viewmodel.HeroViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HeroViewModel(get()) }
}
