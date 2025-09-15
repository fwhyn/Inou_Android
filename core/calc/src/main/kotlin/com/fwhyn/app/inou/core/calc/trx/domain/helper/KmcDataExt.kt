package com.fwhyn.app.inou.core.calc.trx.domain.helper

import com.fwhyn.app.inou.core.calc.trx.data.model.KmcData
import com.fwhyn.app.inou.core.calc.trx.domain.model.KmcDomain

fun KmcData.toDomain(): KmcDomain {
    return KmcDomain(
        timeStamp = this.timeStamp,
        spoO2 = this.spoO2.toDomain(),
        temperature = this.temperature.toDomain(),
        respirationRate = this.respirationRate.toDomain()
    )
}