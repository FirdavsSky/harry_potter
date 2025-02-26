package com.example.harry_potter.data.network


import com.example.harry_potter.data.network.mapper.CharacterMapper
import com.example.harry_potter.domain.model.CharacterModel
import com.example.harry_potter.domain.repository.CharacterRepository

class CharacterRepositoryImpl : CharacterRepository {

    private val mapper = CharacterMapper()

    override suspend fun getCharacters(): List<CharacterModel> {

        return mapper.mapListDtoToModel(RetrofitInstance.searchCharacterApi.getCharacters())
    }

    override suspend fun getCharacterById(id: Int): CharacterModel {

        return mapper.mapDtoToModel(RetrofitInstance.searchCharacterApi.getCharacterById(id))
    }
}