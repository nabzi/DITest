package com.example.manualditest.data

class UserRepository(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource
) {
}