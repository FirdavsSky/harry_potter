package com.example.harry_potter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harry_potter.App
import com.example.harry_potter.data.local.entity.CharacterDb
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class DbViewModel : ViewModel() {

    private val characterDao = (MainActivity().application as App).db.characterDao()

    val allCharacters = characterDao.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            emptyList()
        )

    fun onBtnAdd() {
        val size = characterDao.getAll()
        characterDao.insert(
            CharacterDb(
                name = "Potter $size",
                hogwartsHouse = "Griffindor",

                )
        )
    }
}