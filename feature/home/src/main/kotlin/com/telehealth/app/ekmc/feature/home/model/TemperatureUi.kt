package com.telehealth.app.ekmc.feature.home.model

class TemperatureUi(
    val data: Float,
    val unit: String,
) {
    companion object {
        fun default(
            data: Float = 0f,
            unit: String = "°C",
        ) = TemperatureUi(
            data = data,
            unit = unit,
        )
    }
}