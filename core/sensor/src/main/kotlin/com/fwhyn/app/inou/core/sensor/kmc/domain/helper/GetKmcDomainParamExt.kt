package com.fwhyn.app.inou.core.sensor.kmc.domain.helper

import com.fwhyn.app.inou.core.sensor.kmc.data.model.GetKmcDataParam
import com.fwhyn.app.inou.core.sensor.kmc.domain.model.GetKmcDomainParam

fun GetKmcDomainParam.toData(): GetKmcDataParam {
    return GetKmcDataParam()
}