package com.example.harry_potter.presentation

sealed class ProgressState {

    object Loading: ProgressState()
    object Success: ProgressState()
}