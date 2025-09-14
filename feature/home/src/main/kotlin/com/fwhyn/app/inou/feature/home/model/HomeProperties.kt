package com.fwhyn.app.inou.feature.home.model

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow

data class HomeProperties(
    val event: SharedFlow<HomeEvent>,
    val isRealTimeData: StateFlow<Boolean>,
    val kmcUiList: StateFlow<List<KmcUi>>,
) {
    companion object {
        val started by lazy { WhileSubscribed(5000) }

        fun default(
            event: SharedFlow<HomeEvent> = MutableSharedFlow(),
            isRealTimeData: StateFlow<Boolean> = MutableStateFlow(false),
            kmcUiList: StateFlow<List<KmcUi>> = MutableStateFlow(emptyList()),
        ): HomeProperties {
            return HomeProperties(
                event = event,
                isRealTimeData = isRealTimeData,
                kmcUiList = kmcUiList
            )
        }
    }
}

val homePropertiesFake = HomeProperties.default(
    kmcUiList = MutableStateFlow(kmcUiListFake)
)