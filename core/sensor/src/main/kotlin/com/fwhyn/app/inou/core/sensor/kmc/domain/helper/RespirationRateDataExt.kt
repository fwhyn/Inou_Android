package com.fwhyn.app.inou.core.sensor.kmc.domain.helper

import com.fwhyn.app.inou.core.sensor.kmc.data.model.RespirationRateData
import com.fwhyn.app.inou.core.sensor.kmc.domain.model.RespirationRateDomain

fun RespirationRateData.toDomain(): RespirationRateDomain {
    return RespirationRateDomain(
        data = this.data,
        unit = this.unit,
    )
}