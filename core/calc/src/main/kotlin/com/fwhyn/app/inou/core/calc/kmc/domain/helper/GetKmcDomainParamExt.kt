package com.fwhyn.app.inou.core.calc.kmc.domain.helper

import com.fwhyn.app.inou.core.calc.kmc.data.model.GetKmcDataParam
import com.fwhyn.app.inou.core.calc.kmc.domain.model.GetKmcDomainParam

fun GetKmcDomainParam.toData(): GetKmcDataParam {
    return GetKmcDataParam()
}