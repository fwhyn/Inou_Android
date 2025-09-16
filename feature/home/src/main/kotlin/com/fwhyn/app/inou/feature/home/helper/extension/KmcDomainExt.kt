package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.trx.domain.model.KmcDomain
import com.fwhyn.app.inou.core.common.ui.helper.UiUtil
import com.fwhyn.app.inou.feature.home.model.TransactionUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun KmcDomain.toUi(): TransactionUi {
    return TransactionUi(
        timeStamp = UiUtil.convertTimeStampToDateString(this.timeStamp),
        spoO2 = this.spoO2.toUi(),
        temperature = this.temperature.toUi(),
        respirationRate = this.respirationRate.toUi()
    )
}

fun List<KmcDomain>.toUi(): List<TransactionUi> {
    return this.map { it.toUi() }
}

fun Flow<List<KmcDomain>>.toUi(): Flow<List<TransactionUi>> {
    return this.map { kmcList -> kmcList.toUi() }
}