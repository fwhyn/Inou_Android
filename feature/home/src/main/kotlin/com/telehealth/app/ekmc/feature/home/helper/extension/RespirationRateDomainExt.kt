package com.telehealth.app.ekmc.feature.home.helper.extension

import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.RespirationRateDomain
import com.telehealth.app.ekmc.feature.home.model.RespirationRateUi

fun RespirationRateDomain.toUi(): RespirationRateUi {
    return RespirationRateUi(
        data = this.data,
        unit = this.unit
    )
}