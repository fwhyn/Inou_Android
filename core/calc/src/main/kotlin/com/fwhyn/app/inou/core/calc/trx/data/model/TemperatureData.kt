package com.fwhyn.app.inou.core.calc.trx.data.model

class TemperatureData(
    val data: Float,
    val unit: String,
) {
    companion object {
        fun default(
            data: Float = 0f,
            unit: String = "°C",
        ) = TemperatureData(
            data = data,
            unit = unit,
        )
    }
}