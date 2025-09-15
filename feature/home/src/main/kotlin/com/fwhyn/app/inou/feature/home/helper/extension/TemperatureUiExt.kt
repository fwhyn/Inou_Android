package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.kmc.domain.model.TemperatureDomain
import com.fwhyn.app.inou.feature.home.model.TemperatureUi

fun TemperatureUi.toDomain(): TemperatureDomain {
    return TemperatureDomain(
        data = this.data,
        unit = this.unit
    )
}