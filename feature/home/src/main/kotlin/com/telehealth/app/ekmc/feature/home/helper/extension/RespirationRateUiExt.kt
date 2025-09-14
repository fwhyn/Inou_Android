package com.telehealth.app.ekmc.feature.home.helper.extension

import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.RespirationRateDomain
import com.telehealth.app.ekmc.feature.home.model.RespirationRateUi

fun RespirationRateUi.toDomain(): RespirationRateDomain {
    return RespirationRateDomain(
        data = this.data,
        unit = this.unit
    )
}