package com.example.manualditest.data

import android.util.Log
import retrofit2.Retrofit

class UserRemoteDataSource(val loginApiService : LoginService) {
    fun getUser() : User {
        Log.d("panjshanbe" , "getUser in UserRemoteDataSource called")
        //loginApiService.getUser()
        return User(1 , "karim")
    }
}