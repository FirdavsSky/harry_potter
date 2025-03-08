package com.example.harry_potter.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harry_potter.App
import com.example.harry_potter.data.local.dao.CharacterDao
import com.example.harry_potter.data.local.entity.CharacterDb
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DbViewModel : ViewModel() {

    private lateinit var characterDao: CharacterDao

    private var _characters = MutableStateFlow<List<CharacterDb>>(emptyList())
    val characters = _characters.asStateFlow()

    fun onBtnAdd() {
        var size = _characters.value.size

        viewModelScope.launch {
            characterDao.insert(
                CharacterDb(id = ++size, name = "Potter $size")
            )
            updateTextView()
        }
    }

    fun initDao(application: Application?) {
        characterDao = (application as App).db.characterDao()

        updateTextView()
    }

    fun onDeleteBtn() {

        viewModelScope.launch {

            characters.value.lastOrNull()?.let {

                characterDao.delete(it)
            }
            updateTextView()
        }
    }

    fun onUpdateBtn() {

        viewModelScope.launch {

            characters.value.lastOrNull()?.let {

                characterDao.update(it.copy(name = "Firdavs"))
            }
            updateTextView()
        }
    }

    private fun updateTextView() {

        viewModelScope.launch {

            _characters.value = characterDao.getAll()
        }
    }
}