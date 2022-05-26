package com.example.manualditest.data

import android.util.Log
import com.example.manualditest.model.User


class UserRepository(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource)
{
    var registeredUser : User? = null

    suspend fun register(user : User){
        registeredUser = userRemoteDataSource.register(user).data
        Log.d("zzzz" , registeredUser?.name ?: "null")
    }

    suspend fun updateStatus(stat: String) {
        registeredUser?.let{
            it.status = stat
            userRemoteDataSource.update(it)
        }

    }
}
