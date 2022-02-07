package com.example.pruebatecnica.app

import android.app.Application
import com.example.pruebatecnica.module.networkModule
import com.example.pruebatecnica.module.repositoryModule
import com.example.pruebatecnica.module.useCaseModule
import com.example.pruebatecnica.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HeroApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HeroApplication)
            modules(listOf(viewModelModule, useCaseModule, repositoryModule, networkModule))
        }
    }
}
