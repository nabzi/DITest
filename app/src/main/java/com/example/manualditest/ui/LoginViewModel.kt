package com.example.manualditest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.manualditest.model.User
import com.example.manualditest.data.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(val userRepository: UserRepository) : ViewModel() {


    fun register(name : String , password : String){
        viewModelScope.launch {
            userRepository.register(User(name = name, password = password))
            //updateStatus("new status at work")
        }
    }
    fun updateStatus(status : String ){
        viewModelScope.launch {
            userRepository.updateStatus(status)
        }
    }

}