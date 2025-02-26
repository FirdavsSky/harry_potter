package com.example.harry_potter.domain.usecase

import com.example.harry_potter.domain.model.CharacterModel
import com.example.harry_potter.domain.repository.CharacterRepository

class GetCharacterUseCase(

    private val repository: CharacterRepository
) {

    suspend fun getCharacter(id: Int = 1): CharacterModel {

        return repository.getCharacterById(id)
    }
}