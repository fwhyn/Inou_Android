package com.fwhyn.app.inou.core.calc.kmc.data.model

data class RespirationRateData(
    val data: Int,
    val unit: String,
) {
    companion object {
        fun default(
            data: Int = 0,
            unit: String = "breaths/min",
        ) = RespirationRateData(
            data = data,
            unit = unit,
        )
    }
}