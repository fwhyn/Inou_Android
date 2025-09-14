package com.fwhyn.app.inou.core.sensor.kmc.domain.helper

import com.fwhyn.app.inou.core.sensor.kmc.data.model.KmcData
import com.fwhyn.app.inou.core.sensor.kmc.domain.model.KmcDomain

fun KmcData.toDomain(): KmcDomain {
    return KmcDomain(
        timeStamp = this.timeStamp,
        spoO2 = this.spoO2.toDomain(),
        temperature = this.temperature.toDomain(),
        respirationRate = this.respirationRate.toDomain()
    )
}