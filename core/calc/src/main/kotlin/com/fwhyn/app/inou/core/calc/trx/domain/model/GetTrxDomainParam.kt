package com.fwhyn.app.inou.core.calc.trx.domain.model

data class GetTrxDomainParam(
    val isRealTime: Boolean,
    val maxDataList: Int,
) {

    companion object {
        fun default(
            isRealTime: Boolean = false,
            maxDataList: Int = 100,
        ): GetTrxDomainParam {
            return GetTrxDomainParam(
                isRealTime = isRealTime,
                maxDataList = maxDataList
            )
        }
    }
}