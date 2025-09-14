package com.telehealth.app.ekmc.core.sensor.kmc.data.remote

import com.telehealth.app.ekmc.core.sensor.kmc.data.model.KmcData
import com.telehealth.app.ekmc.core.sensor.kmc.data.model.KmcSensorParam

class KmcSensorDataSourceReal : KmcSensorDataSource {

    override suspend fun get(param: KmcSensorParam): KmcData {
        TODO("Implement the method to fetch KmcData from the remote source")
    }
}