package com.example.manualditest.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.manualditest.data.UserRepository

class LoginViewModel(val userRepository: UserRepository) : ViewModel() {

    var user = userRepository.getUser()

}