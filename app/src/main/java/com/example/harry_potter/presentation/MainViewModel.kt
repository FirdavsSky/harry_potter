package com.example.harry_potter.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harry_potter.domain.model.CharacterModel
import com.example.harry_potter.domain.usecase.GetCharacterListUseCase
import com.example.harry_potter.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val getCharacterUseCase: GetCharacterUseCase,
) : ViewModel() {

    private var _state: MutableStateFlow<ProgressState> = MutableStateFlow(ProgressState.Success)
    val state = _state.asStateFlow()

    private val _character = MutableStateFlow(
        CharacterModel()
    )
    val character = _character.asStateFlow()

    private val _characterList = MutableStateFlow<List<CharacterModel>>(
        emptyList()
    )
    val characterList = _characterList.asStateFlow()

    init {

        viewModelScope.launch {
            _state.value = ProgressState.Loading
            try {

                _character.value = getCharacterUseCase.getCharacter()
                _characterList.value = getCharacterListUseCase.getCharacter()
            } catch (e: Throwable) {

                Log.e(TAG, e.message.toString())
            }
            _state.value = ProgressState.Success
        }
    }

    fun randomCharacter() {

        _state.value = ProgressState.Loading
        _character.value = _characterList.value.random()
        _state.value = ProgressState.Success
    }
}