package com.fwhyn.app.inou.core.calc.trx.domain.helper

import com.fwhyn.app.inou.core.calc.trx.data.model.TemperatureData
import com.fwhyn.app.inou.core.calc.trx.domain.model.TemperatureDomain

fun TemperatureData.toDomain(): TemperatureDomain {
    return TemperatureDomain(
        data = this.data,
        unit = this.unit,
    )
}