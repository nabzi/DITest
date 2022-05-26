package com.example.manualditest.model

data class Resource<T>(var status: Status, var data: T?, var message: String? = null)

enum class Status{
    LOADING,
    SUCCESS,
    FAIL
}