package com.fwhyn.app.inou.core.calc.trx.data.repository

import com.fwhyn.app.inou.core.calc.trx.data.model.GetKmcDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.KmcData
import com.fwhyn.app.inou.core.calc.trx.data.model.SetKmcDataParam
import com.fwhyn.lib.baze.common.helper.BaseGetter
import com.fwhyn.lib.baze.common.helper.BaseSetter

interface KmcDataRepository :
    BaseGetter<GetKmcDataParam, KmcData>,
    BaseSetter<SetKmcDataParam, KmcData>