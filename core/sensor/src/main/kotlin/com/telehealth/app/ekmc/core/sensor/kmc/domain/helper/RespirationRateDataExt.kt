package com.telehealth.app.ekmc.core.sensor.kmc.domain.helper

import com.telehealth.app.ekmc.core.sensor.kmc.data.model.RespirationRateData
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.RespirationRateDomain

fun RespirationRateData.toDomain(): RespirationRateDomain {
    return RespirationRateDomain(
        data = this.data,
        unit = this.unit,
    )
}