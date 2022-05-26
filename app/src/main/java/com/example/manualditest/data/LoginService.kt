package com.example.manualditest.data


import com.example.manualditest.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface LoginService {

//    @GET("/")
//    fun getUser() : User

    @POST("users")
    suspend fun register(@Body user: User): Response<User>

    @PUT("users/{id}")
    suspend fun updateUser (@Body user: User, @Path("id") id : String) : Unit
}