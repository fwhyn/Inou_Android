package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.sensor.kmc.domain.model.SpoO2Domain
import com.fwhyn.app.inou.feature.home.model.SpoO2Ui

fun SpoO2Ui.toDomain(): SpoO2Domain {
    return SpoO2Domain(
        data = this.data,
        unit = this.unit
    )
}