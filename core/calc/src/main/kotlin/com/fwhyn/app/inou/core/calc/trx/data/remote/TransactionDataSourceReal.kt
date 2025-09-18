package com.fwhyn.app.inou.core.calc.trx.data.remote

import com.fwhyn.app.inou.core.calc.trx.data.model.GetTrxDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.TransactionData

class TransactionDataSourceReal : TransactionDataSource {

    override suspend fun get(param: GetTrxDataParam): TransactionData {
        TODO("Implement the method to fetch TransactionData from the remote source")
    }
}