package com.fwhyn.app.inou.core.calc.kmc.data.remote

import com.fwhyn.app.inou.core.calc.kmc.data.model.KmcData
import com.fwhyn.app.inou.core.calc.kmc.data.model.KmccalcParam
import com.fwhyn.lib.baze.common.helper.BaseGetter

interface KmccalcDataSource : BaseGetter<KmccalcParam, KmcData>