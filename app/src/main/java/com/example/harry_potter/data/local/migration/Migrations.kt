package com.example.harry_potter.data.local.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1,2){

    override fun migrate(db: SupportSQLiteDatabase) {

        db.execSQL("ALTER TABLE character ADD COLUMN birthday TEXT")
    }
}

val MIGRATION_2_3 = object : Migration(2,3){

    override fun migrate(db: SupportSQLiteDatabase) {

        db.execSQL("ALTER TABLE character ADD COLUMN hogwarts_house TEXT")
        db.execSQL("ALTER TABLE character ADD COLUMN image_url TEXT")
    }
}