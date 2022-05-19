package com.example.manualditest.domain

import com.example.manualditest.data.LoginService
import com.example.manualditest.data.UserLocalDataSource
import com.example.manualditest.data.UserRemoteDataSource
import com.example.manualditest.data.UserRepository
import com.example.manualditest.ui.LoginViewModel
import retrofit2.Retrofit

class LoginContainer(userRepository: UserRepository){
    val loginViewModelFactory = LoginViewModelFactory(userRepository)
}


class Container {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://example.com")
        .build()

    val loginApiService = retrofit.create(LoginService::class.java)

    val userLocalDataSource = UserLocalDataSource()
    val userRemoteDataSource = UserRemoteDataSource(loginApiService)

    val userRepository = UserRepository(userLocalDataSource, userRemoteDataSource)

    var loginContainer: LoginContainer? = null
}


interface Factory<T> {
    fun create(): T
}

class LoginViewModelFactory(private val userRepository: UserRepository) : Factory<LoginViewModel> {
    override fun create(): LoginViewModel {
        return LoginViewModel(userRepository)
    }
}