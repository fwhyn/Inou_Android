package com.telehealth.app.ekmc.core.sensor.kmc.data.remote

import com.fwhyn.lib.baze.common.helper.BaseGetter
import com.telehealth.app.ekmc.core.sensor.kmc.data.model.KmcData
import com.telehealth.app.ekmc.core.sensor.kmc.data.model.KmcSensorParam

interface KmcSensorDataSource : BaseGetter<KmcSensorParam, KmcData>