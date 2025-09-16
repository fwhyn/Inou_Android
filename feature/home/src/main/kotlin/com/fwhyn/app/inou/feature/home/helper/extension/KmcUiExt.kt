package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.trx.domain.model.KmcDomain
import com.fwhyn.app.inou.core.common.ui.helper.UiUtil
import com.fwhyn.app.inou.feature.home.model.TransactionUi

fun TransactionUi.toDomain(): KmcDomain {
    return KmcDomain(
        timeStamp = UiUtil.convertDateStringToTimeStamp(this.timeStamp),
        spoO2 = this.spoO2.toDomain(),
        temperature = this.temperature.toDomain(),
        respirationRate = this.respirationRate.toDomain()
    )
}

fun List<TransactionUi>.toDomain(): List<KmcDomain> {
    return this.map {
        it.toDomain()
    }
}