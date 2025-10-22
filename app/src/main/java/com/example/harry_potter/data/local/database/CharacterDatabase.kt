package com.example.harry_potter.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.harry_potter.data.local.dao.CharacterDao
import com.example.harry_potter.data.local.entity.CharacterDb

@Database(entities = [CharacterDb::class], version = 3)
abstract class CharacterDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}