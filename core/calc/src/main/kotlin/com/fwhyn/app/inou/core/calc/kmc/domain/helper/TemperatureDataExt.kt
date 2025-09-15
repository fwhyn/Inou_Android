package com.fwhyn.app.inou.core.calc.kmc.domain.helper

import com.fwhyn.app.inou.core.calc.kmc.data.model.TemperatureData
import com.fwhyn.app.inou.core.calc.kmc.domain.model.TemperatureDomain

fun TemperatureData.toDomain(): TemperatureDomain {
    return TemperatureDomain(
        data = this.data,
        unit = this.unit,
    )
}