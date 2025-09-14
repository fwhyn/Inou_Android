package com.telehealth.app.ekmc.core.sensor.kmc.data.repository

import com.fwhyn.lib.baze.common.helper.BaseGetter
import com.fwhyn.lib.baze.common.helper.BaseSetter
import com.telehealth.app.ekmc.core.sensor.kmc.data.model.GetKmcDataParam
import com.telehealth.app.ekmc.core.sensor.kmc.data.model.KmcData
import com.telehealth.app.ekmc.core.sensor.kmc.data.model.SetKmcDataParam

interface KmcDataRepository :
    BaseGetter<GetKmcDataParam, KmcData>,
    BaseSetter<SetKmcDataParam, KmcData>