package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.trx.domain.model.RespirationRateDomain
import com.fwhyn.app.inou.feature.home.model.RespirationRateUi

fun RespirationRateDomain.toUi(): RespirationRateUi {
    return RespirationRateUi(
        data = this.data,
        unit = this.unit
    )
}