package com.example.harry_potter.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.harry_potter.data.local.entity.CharacterDb
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character")
    fun getAll(): Flow<List<CharacterDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterDb: CharacterDb)

    @Update
    suspend fun update(characterDb: CharacterDb)

    @Delete
    suspend fun delete(characterDb: CharacterDb)
}