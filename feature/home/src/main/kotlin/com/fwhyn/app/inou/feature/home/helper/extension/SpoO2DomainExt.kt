package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.sensor.kmc.domain.model.SpoO2Domain
import com.fwhyn.app.inou.feature.home.model.SpoO2Ui

fun SpoO2Domain.toUi(): SpoO2Ui {
    return SpoO2Ui(
        data = this.data,
        unit = this.unit
    )
}