package com.example.manualditest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manualditest.App
import com.example.manualditest.R
import com.example.manualditest.domain.Container
import com.example.manualditest.domain.LoginContainer

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginContainer =  LoginContainer(( application as App).appContainer.userRepository)
        ( application as App).appContainer.loginContainer = loginContainer
        viewModel =  loginContainer.loginViewModelFactory.create()
    }

    override fun onDestroy() {
        super.onDestroy()
        ( application as App).appContainer.loginContainer = null
    }
}