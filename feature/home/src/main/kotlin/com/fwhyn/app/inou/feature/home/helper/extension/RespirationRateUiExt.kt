package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.trx.domain.model.RespirationRateDomain
import com.fwhyn.app.inou.feature.home.model.RespirationRateUi

fun RespirationRateUi.toDomain(): RespirationRateDomain {
    return RespirationRateDomain(
        data = this.data,
        unit = this.unit
    )
}