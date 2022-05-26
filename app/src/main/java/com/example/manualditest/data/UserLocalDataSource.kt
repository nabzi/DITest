package com.example.manualditest.data

import android.util.Log
import com.example.manualditest.model.User

class UserLocalDataSource() {
    fun setUser(user: User) {
        //save in database >  userDao.save(user)
        Log.d("panjshanbe" , "save user in db")
    }
}