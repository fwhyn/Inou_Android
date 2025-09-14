package com.telehealth.app.ekmc.feature.home.helper.extension

import com.telehealth.app.ekmc.core.common.ui.helper.UiUtil
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.KmcDomain
import com.telehealth.app.ekmc.feature.home.model.KmcUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun KmcDomain.toUi(): KmcUi {
    return KmcUi(
        timeStamp = UiUtil.convertTimeStampToDateString(this.timeStamp),
        spoO2 = this.spoO2.toUi(),
        temperature = this.temperature.toUi(),
        respirationRate = this.respirationRate.toUi()
    )
}

fun List<KmcDomain>.toUi(): List<KmcUi> {
    return this.map { it.toUi() }
}

fun Flow<List<KmcDomain>>.toUi(): Flow<List<KmcUi>> {
    return this.map { kmcList -> kmcList.toUi() }
}