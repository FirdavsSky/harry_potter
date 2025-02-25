package com.example.harry_potter.data.network

import retrofit2.http.GET

interface SearchCharactersApi{

    @GET("")
    fun getCharacters()

    fun getCharacterById()
}