package com.fwhyn.app.inou.core.calc.trx.domain.model

data class KmcDomain(
    val timeStamp: Long,
    val spoO2: SpoO2Domain,
    val temperature: TemperatureDomain,
    val respirationRate: RespirationRateDomain,
)