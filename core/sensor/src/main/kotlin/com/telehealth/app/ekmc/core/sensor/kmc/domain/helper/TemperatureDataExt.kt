package com.telehealth.app.ekmc.core.sensor.kmc.domain.helper

import com.telehealth.app.ekmc.core.sensor.kmc.data.model.TemperatureData
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.TemperatureDomain

fun TemperatureData.toDomain(): TemperatureDomain {
    return TemperatureDomain(
        data = this.data,
        unit = this.unit,
    )
}