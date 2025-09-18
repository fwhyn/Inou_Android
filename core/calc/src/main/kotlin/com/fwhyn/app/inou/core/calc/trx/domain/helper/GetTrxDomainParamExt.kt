package com.fwhyn.app.inou.core.calc.trx.domain.helper

import com.fwhyn.app.inou.core.calc.trx.data.model.GetTrxDataParam
import com.fwhyn.app.inou.core.calc.trx.domain.model.GetTrxDomainParam

fun GetTrxDomainParam.toData(): GetTrxDataParam {
    return GetTrxDataParam()
}