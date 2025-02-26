package com.example.harry_potter.domain.model

data class CharacterModel(
    val id: Int = 0,
    val name: String = "Unknown",
    val hogwartsHouse: String = "Slytherin",
    val imageUrl: String = ""
)