package com.fwhyn.app.inou.core.sensor.kmc.data.model

data class SpoO2Data(
    val data: Int,
    val unit: String,
) {
    companion object {
        fun default(
            data: Int = 0,
            unit: String = "%",
        ) = SpoO2Data(
            data = data,
            unit = unit,
        )
    }
}