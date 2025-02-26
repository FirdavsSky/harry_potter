package com.example.harry_potter.domain.usecase

import com.example.harry_potter.domain.model.CharacterModel
import com.example.harry_potter.domain.repository.CharacterRepository

class GetCharacterListUseCase(

    private val repository: CharacterRepository
) {

    suspend fun getCharacter(): List<CharacterModel> {

        return repository.getCharacters()
    }
}