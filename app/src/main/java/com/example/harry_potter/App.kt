package com.example.harry_potter

import android.app.Application
import androidx.room.Room
import com.example.harry_potter.data.local.database.CharacterDatabase
import com.example.harry_potter.data.local.migration.MIGRATION_1_2
import com.example.harry_potter.data.local.migration.MIGRATION_2_3

class App : Application() {

    lateinit var db: CharacterDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

        db = Room.databaseBuilder(this, CharacterDatabase::class.java, "db")
            .fallbackToDestructiveMigration()
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .build()
    }

    companion object {

        lateinit var INSTANCE: App
            private set
    }
}