package com.fwhyn.app.inou.core.calc.trx.data.remote

import com.fwhyn.app.inou.core.calc.trx.data.model.KmcData
import com.fwhyn.app.inou.core.calc.trx.data.model.KmccalcParam
import com.fwhyn.lib.baze.common.helper.BaseGetter

interface KmccalcDataSource : BaseGetter<KmccalcParam, KmcData>