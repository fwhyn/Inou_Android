package com.fwhyn.app.inou.feature.home.model

import com.fwhyn.app.inou.feature.home.component.HomeMessageCode
import com.fwhyn.app.inou.feature.home.helper.OpenSafCode

sealed class HomeEvent {
    data class Notify(val code: HomeMessageCode) : HomeEvent()
    data class OpenSaf(val code: OpenSafCode) : HomeEvent()
}