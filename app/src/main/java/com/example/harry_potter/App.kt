package com.example.harry_potter

import android.app.Application
import androidx.room.Room
import com.example.harry_potter.data.local.database.CharacterDatabase

class App : Application() {

    lateinit var db: CharacterDatabase

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(applicationContext, CharacterDatabase::class.java, "db").build()
    }
}