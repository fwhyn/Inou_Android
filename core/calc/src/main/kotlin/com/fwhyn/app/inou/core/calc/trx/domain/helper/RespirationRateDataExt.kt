package com.fwhyn.app.inou.core.calc.trx.domain.helper

import com.fwhyn.app.inou.core.calc.trx.data.model.RespirationRateData
import com.fwhyn.app.inou.core.calc.trx.domain.model.RespirationRateDomain

fun RespirationRateData.toDomain(): RespirationRateDomain {
    return RespirationRateDomain(
        data = this.data,
        unit = this.unit,
    )
}