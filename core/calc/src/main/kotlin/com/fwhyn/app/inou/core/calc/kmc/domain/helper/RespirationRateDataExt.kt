package com.fwhyn.app.inou.core.calc.kmc.domain.helper

import com.fwhyn.app.inou.core.calc.kmc.data.model.RespirationRateData
import com.fwhyn.app.inou.core.calc.kmc.domain.model.RespirationRateDomain

fun RespirationRateData.toDomain(): RespirationRateDomain {
    return RespirationRateDomain(
        data = this.data,
        unit = this.unit,
    )
}