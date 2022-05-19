package com.example.manualditest.di

import com.example.manualditest.data.*
import com.example.manualditest.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

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
        val retrofit = Retrofit.Builder()
            .baseUrl("https://example.com")
            .build()
        retrofit
    }

    viewModel { LoginViewModel (get()) }

}