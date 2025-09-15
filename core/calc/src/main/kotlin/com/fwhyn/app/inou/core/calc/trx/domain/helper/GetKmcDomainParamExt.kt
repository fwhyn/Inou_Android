package com.fwhyn.app.inou.core.calc.trx.domain.helper

import com.fwhyn.app.inou.core.calc.trx.data.model.GetKmcDataParam
import com.fwhyn.app.inou.core.calc.trx.domain.model.GetKmcDomainParam

fun GetKmcDomainParam.toData(): GetKmcDataParam {
    return GetKmcDataParam()
}