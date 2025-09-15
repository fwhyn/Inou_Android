package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.trx.domain.model.TemperatureDomain
import com.fwhyn.app.inou.feature.home.model.TemperatureUi

fun TemperatureDomain.toUi(): TemperatureUi {
    return TemperatureUi(
        data = this.data,
        unit = this.unit
    )
}