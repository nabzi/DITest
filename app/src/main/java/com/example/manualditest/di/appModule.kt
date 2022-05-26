package com.example.manualditest.di

import com.example.manualditest.data.*
import com.example.manualditest.ui.LoginViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {

    single { UserRepository(get(), get()) }

    single { UserLocalDataSource() }

    single { UserRemoteDataSource(get()) }

    single {
        val retrofit = get() as Retrofit
        val loginApiService = retrofit.create(LoginService::class.java)

        loginApiService
    }
    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://6086fa75a3b9c200173b758e.mockapi.io/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
        retrofit
    }

    viewModel { LoginViewModel (get()) }
}