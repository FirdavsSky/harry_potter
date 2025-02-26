package com.example.harry_potter.data.network.mapper

import com.example.harry_potter.data.network.dto.CharacterDto
import com.example.harry_potter.domain.model.CharacterModel

class CharacterMapper {

    fun mapDtoToModel(characterDto: CharacterDto) = CharacterModel(
        id = characterDto.id,
        name = characterDto.name,
        hogwartsHouse = characterDto.hogwartsHouse,
        imageUrl = characterDto.imageUrl
    )

    fun mapListDtoToModel(dtoList: List<CharacterDto>): List<CharacterModel> {

        return dtoList.map {
            mapDtoToModel(it)
        }
    }
}