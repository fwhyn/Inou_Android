package com.telehealth.app.ekmc.core.sensor.kmc.domain.helper

import com.telehealth.app.ekmc.core.sensor.kmc.data.model.GetKmcDataParam
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.GetKmcDomainParam

fun GetKmcDomainParam.toData(): GetKmcDataParam {
    return GetKmcDataParam()
}