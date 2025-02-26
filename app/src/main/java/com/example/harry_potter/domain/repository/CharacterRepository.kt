package com.example.harry_potter.domain.repository

import com.example.harry_potter.domain.model.CharacterModel

interface CharacterRepository {

    suspend fun getCharacters(): List<CharacterModel>

    suspend fun getCharacterById(id: Int): CharacterModel
}