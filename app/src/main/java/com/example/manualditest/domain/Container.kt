package com.example.manualditest.domain

import com.example.manualditest.data.*
import com.example.manualditest.ui.LoginViewModel
import retrofit2.Retrofit

/*
* sample of dependency injection with service locator
* */
class Container {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://example.com")
        .build()

    val loginApiService = retrofit.create(LoginService::class.java)

    val userLocalDataSource = UserLocalDataSource()
    val userRemoteDataSource = UserRemoteDataSource(loginApiService)

    val userRepository = UserRepository(userLocalDataSource, userRemoteDataSource)

    val loginViewModel = LoginViewModel(userRepository)


}
