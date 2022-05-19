package com.example.manualditest

import android.app.Application
import com.example.manualditest.domain.Container

class App : Application() {
    val appContainer = Container()
}