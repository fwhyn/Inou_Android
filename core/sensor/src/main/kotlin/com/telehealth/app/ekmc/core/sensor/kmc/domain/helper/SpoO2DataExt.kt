package com.telehealth.app.ekmc.core.sensor.kmc.domain.helper

import com.telehealth.app.ekmc.core.sensor.kmc.data.model.SpoO2Data
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.SpoO2Domain

fun SpoO2Data.toDomain(): SpoO2Domain {
    return SpoO2Domain(
        data = this.data,
        unit = this.unit,
    )
}