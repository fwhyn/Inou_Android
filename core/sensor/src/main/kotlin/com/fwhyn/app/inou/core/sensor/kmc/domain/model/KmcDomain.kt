package com.fwhyn.app.inou.core.sensor.kmc.domain.model

data class KmcDomain(
    val timeStamp: Long,
    val spoO2: SpoO2Domain,
    val temperature: TemperatureDomain,
    val respirationRate: RespirationRateDomain,
)