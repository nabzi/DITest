package com.example.manualditest.ui
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.manualditest.App
import com.example.manualditest.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    val loginViewModel : LoginViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val tvName = findViewById<TextView>(R.id.tvName)
        //tvName.text = loginViewModel.user.name
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            loginViewModel.register("saeed" , "444444")
        }
    }
}