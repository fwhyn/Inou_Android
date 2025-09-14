package com.telehealth.app.ekmc.feature.home.model

import com.telehealth.app.ekmc.feature.home.component.HomeMessageCode
import com.telehealth.app.ekmc.feature.home.helper.OpenSafCode

sealed class HomeEvent {
    data class Notify(val code: HomeMessageCode) : HomeEvent()
    data class OpenSaf(val code: OpenSafCode) : HomeEvent()
}