package com.example.pruebatecnica.module

import com.example.pruebatecnica.data.networkEndPoints.HeroApi
import com.example.pruebatecnica.tools.urlBase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule: Module = module {
    single(named("retrofit")) { provideRetrofit() }
    factory { get<Retrofit>(named("retrofit")).create(HeroApi::class.java) }
}

fun provideRetrofit(): Retrofit {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    return Retrofit.Builder()
        .baseUrl(urlBase)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}
