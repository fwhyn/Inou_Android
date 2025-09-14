package com.telehealth.app.ekmc.core.sensor.kmc.domain.model

class TemperatureDomain(
    val data: Float,
    val unit: String,
) {
    companion object {
        fun default(
            data: Float = 0f,
            unit: String = "°C",
        ) = TemperatureDomain(
            data = data,
            unit = unit,
        )
    }
}