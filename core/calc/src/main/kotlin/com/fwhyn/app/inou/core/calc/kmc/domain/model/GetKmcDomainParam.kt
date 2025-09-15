package com.fwhyn.app.inou.core.calc.kmc.domain.model

data class GetKmcDomainParam(
    val isRealTime: Boolean,
    val maxDataList: Int,
) {

    companion object {
        fun default(
            isRealTime: Boolean = false,
            maxDataList: Int = 100,
        ): GetKmcDomainParam {
            return GetKmcDomainParam(
                isRealTime = isRealTime,
                maxDataList = maxDataList
            )
        }
    }
}