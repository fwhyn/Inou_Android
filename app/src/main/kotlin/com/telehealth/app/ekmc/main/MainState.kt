package com.telehealth.app.ekmc.main

sealed class MainState {
    data object Loading : MainState()
    data object Finish : MainState()
}