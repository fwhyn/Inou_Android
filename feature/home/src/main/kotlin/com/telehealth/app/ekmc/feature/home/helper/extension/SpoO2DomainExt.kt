package com.telehealth.app.ekmc.feature.home.helper.extension

import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.SpoO2Domain
import com.telehealth.app.ekmc.feature.home.model.SpoO2Ui

fun SpoO2Domain.toUi(): SpoO2Ui {
    return SpoO2Ui(
        data = this.data,
        unit = this.unit
    )
}