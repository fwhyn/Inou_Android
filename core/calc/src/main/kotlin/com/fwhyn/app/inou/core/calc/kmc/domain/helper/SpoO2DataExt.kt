package com.fwhyn.app.inou.core.calc.kmc.domain.helper

import com.fwhyn.app.inou.core.calc.kmc.data.model.SpoO2Data
import com.fwhyn.app.inou.core.calc.kmc.domain.model.SpoO2Domain

fun SpoO2Data.toDomain(): SpoO2Domain {
    return SpoO2Domain(
        data = this.data,
        unit = this.unit,
    )
}