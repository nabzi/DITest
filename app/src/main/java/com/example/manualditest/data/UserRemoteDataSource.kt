package com.example.manualditest.data

import android.util.Log
import com.example.manualditest.model.Resource
import com.example.manualditest.model.Status
import com.example.manualditest.model.User
import com.squareup.moshi.JsonAdapter

import com.squareup.moshi.Moshi




class UserRemoteDataSource(val loginApiService : LoginService) {
    fun getUser() : User {
        Log.d("panjshanbe" , "getUser in UserRemoteDataSource called")
        //loginApiService.getUser()
        return User("1" , "karim" , "111111", "")
    }

    suspend fun register(user: User)  : Resource<User> {


        var result = Resource<User>(Status.LOADING , null)
        try {
            var response = loginApiService.register(user)
            if(response.isSuccessful){
                //todo
                 result.data = response.body() as User
                 result.status = Status.SUCCESS
            }else
                return Resource(Status.FAIL , null , response.message())
        }
        catch (ex: Exception){
            return Resource(Status.FAIL , null , ex.message)
        }
        return result
    }

    suspend fun update(user: User) = loginApiService.updateUser(user , user.id)


    fun convertToUser(userJson : String): User?{
        val moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<User> =
            moshi.adapter<User>(User::class.java)

        val user = jsonAdapter.fromJson(userJson)
        return user
    }

}