package com.fwhyn.app.inou.core.sensor.kmc.domain.helper

import com.fwhyn.app.inou.core.sensor.kmc.data.model.TemperatureData
import com.fwhyn.app.inou.core.sensor.kmc.domain.model.TemperatureDomain

fun TemperatureData.toDomain(): TemperatureDomain {
    return TemperatureDomain(
        data = this.data,
        unit = this.unit,
    )
}