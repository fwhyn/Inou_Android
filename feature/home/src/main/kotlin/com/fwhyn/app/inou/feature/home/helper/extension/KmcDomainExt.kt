package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.kmc.domain.model.KmcDomain
import com.fwhyn.app.inou.core.common.ui.helper.UiUtil
import com.fwhyn.app.inou.feature.home.model.KmcUi
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