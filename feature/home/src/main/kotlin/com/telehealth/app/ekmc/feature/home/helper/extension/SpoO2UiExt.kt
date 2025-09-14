package com.telehealth.app.ekmc.feature.home.helper.extension

import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.SpoO2Domain
import com.telehealth.app.ekmc.feature.home.model.SpoO2Ui

fun SpoO2Ui.toDomain(): SpoO2Domain {
    return SpoO2Domain(
        data = this.data,
        unit = this.unit
    )
}