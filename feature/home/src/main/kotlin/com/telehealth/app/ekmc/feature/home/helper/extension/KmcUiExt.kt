package com.telehealth.app.ekmc.feature.home.helper.extension

import com.telehealth.app.ekmc.core.common.ui.helper.UiUtil
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.KmcDomain
import com.telehealth.app.ekmc.feature.home.model.KmcUi

fun KmcUi.toDomain(): KmcDomain {
    return KmcDomain(
        timeStamp = UiUtil.convertDateStringToTimeStamp(this.timeStamp),
        spoO2 = this.spoO2.toDomain(),
        temperature = this.temperature.toDomain(),
        respirationRate = this.respirationRate.toDomain()
    )
}

fun List<KmcUi>.toDomain(): List<KmcDomain> {
    return this.map {
        it.toDomain()
    }
}