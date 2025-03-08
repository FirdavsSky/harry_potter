package com.example.harry_potter

import android.app.Application
import androidx.room.Room
import com.example.harry_potter.data.local.database.CharacterDatabase

class App : Application() {

    lateinit var db: CharacterDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

        db = Room.inMemoryDatabaseBuilder(this, CharacterDatabase::class.java)
            .fallbackToDestructiveMigration().build()
    }

    companion object {

        lateinit var INSTANCE: App
            private set
    }
}