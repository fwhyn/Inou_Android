package com.fwhyn.app.inou.core.calc.trx.data.repository

import com.fwhyn.app.inou.core.calc.trx.data.model.GetTrxDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.SetTrxDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.TransactionData
import com.fwhyn.lib.baze.common.helper.BaseGetter
import com.fwhyn.lib.baze.common.helper.BaseSetter

interface KmcDataRepository :
    BaseGetter<GetTrxDataParam, TransactionData>,
    BaseSetter<SetTrxDataParam, TransactionData>