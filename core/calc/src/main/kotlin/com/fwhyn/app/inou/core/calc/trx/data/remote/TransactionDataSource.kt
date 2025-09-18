package com.fwhyn.app.inou.core.calc.trx.data.remote

import com.fwhyn.app.inou.core.calc.trx.data.model.GetTrxDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.TransactionData
import com.fwhyn.lib.baze.common.helper.BaseGetter

interface TransactionDataSource : BaseGetter<GetTrxDataParam, TransactionData>