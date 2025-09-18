package com.fwhyn.app.inou.core.calc.trx.data.repository

import com.fwhyn.app.inou.core.calc.trx.data.model.GetTrxDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.SetTrxDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.TransactionData
import com.fwhyn.app.inou.core.calc.trx.data.model.transactionDataFake
import javax.inject.Inject

class KmcDataRepositoryFake @Inject constructor() : KmcDataRepository {
    private var index = 0L
        get() {
            if (field == Long.MAX_VALUE) {
                field = 0 // Reset index after max value
            }
            field++

            return field
        }

    override suspend fun get(param: GetTrxDataParam): TransactionData {
        return transactionDataFake.copy(timeStamp = index)
    }

    override suspend fun set(param: SetTrxDataParam, data: TransactionData) {
        TODO("Not yet implemented")
    }

}