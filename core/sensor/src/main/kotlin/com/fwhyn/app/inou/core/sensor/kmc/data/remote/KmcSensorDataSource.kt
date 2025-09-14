package com.fwhyn.app.inou.core.sensor.kmc.data.remote

import com.fwhyn.app.inou.core.sensor.kmc.data.model.KmcData
import com.fwhyn.app.inou.core.sensor.kmc.data.model.KmcSensorParam
import com.fwhyn.lib.baze.common.helper.BaseGetter

interface KmcSensorDataSource : BaseGetter<KmcSensorParam, KmcData>