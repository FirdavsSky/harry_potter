package com.example.harry_potter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.harry_potter.data.network.CharacterRepositoryImpl
import com.example.harry_potter.domain.usecase.GetCharacterListUseCase
import com.example.harry_potter.domain.usecase.GetCharacterUseCase

class MainViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)){

            val repo = CharacterRepositoryImpl()
            val useCase = GetCharacterUseCase(repo)
            val useCase2 = GetCharacterListUseCase(repo)
            return MainViewModel(useCase2,useCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}