package com.example.harry_potter.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

//@Entity(tableName = "wand")
data class Wand(
    @ColumnInfo(name = "core")
    val core: String,
    @ColumnInfo(name = "length")
    val length: Int
)