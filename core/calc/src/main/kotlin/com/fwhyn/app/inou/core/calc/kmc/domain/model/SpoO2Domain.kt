package com.fwhyn.app.inou.core.calc.kmc.domain.model

data class SpoO2Domain(
    val data: Int,
    val unit: String,
) {
    companion object {
        fun default(
            data: Int = 0,
            unit: String = "%",
        ) = SpoO2Domain(
            data = data,
            unit = unit,
        )
    }
}