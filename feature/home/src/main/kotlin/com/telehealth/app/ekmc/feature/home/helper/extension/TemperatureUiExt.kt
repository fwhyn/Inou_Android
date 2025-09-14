package com.telehealth.app.ekmc.feature.home.helper.extension

import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.TemperatureDomain
import com.telehealth.app.ekmc.feature.home.model.TemperatureUi

fun TemperatureUi.toDomain(): TemperatureDomain {
    return TemperatureDomain(
        data = this.data,
        unit = this.unit
    )
}