package com.fwhyn.app.inou.main

sealed class MainState {
    data object Loading : MainState()
    data object Finish : MainState()
}