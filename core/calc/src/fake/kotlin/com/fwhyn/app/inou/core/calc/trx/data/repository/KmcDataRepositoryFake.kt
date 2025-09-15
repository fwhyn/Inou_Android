package com.fwhyn.app.inou.core.calc.trx.data.repository

import com.fwhyn.app.inou.core.calc.trx.data.model.GetKmcDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.KmcData
import com.fwhyn.app.inou.core.calc.trx.data.model.SetKmcDataParam
import com.fwhyn.app.inou.core.calc.trx.data.model.kmcDataFake
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

    override suspend fun get(param: GetKmcDataParam): KmcData {
        return kmcDataFake.copy(timeStamp = index)
    }

    override suspend fun set(param: SetKmcDataParam, data: KmcData) {
        TODO("Not yet implemented")
    }

}