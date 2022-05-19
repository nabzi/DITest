package com.example.manualditest.data

import android.util.Log


class UserRepository(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource)
{
     fun getUser() : User {
        Log.d("panjshanbe" , "getUser in UserRepository called")
        val user = userRemoteDataSource.getUser()
        userLocalDataSource.setUser(user)
        return  user
    }
}
