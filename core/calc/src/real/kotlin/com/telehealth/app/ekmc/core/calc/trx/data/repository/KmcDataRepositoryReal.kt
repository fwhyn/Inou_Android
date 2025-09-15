package com.fwhyn.app.inou.feature.func.calc.trx.data.repository

import com.fwhyn.app.inou.feature.func.calc.trx.data.model.GetKmcDataParam
import com.fwhyn.app.inou.feature.func.calc.trx.data.model.KmcData
import com.fwhyn.app.inou.feature.func.calc.trx.data.model.SetKmcDataParam
import javax.inject.Inject

class KmcDataRepositoryReal @Inject constructor(

) : KmcDataRepository {
    override suspend fun get(param: GetKmcDataParam): KmcData {
        TODO("Not yet implemented")
    }

    override suspend fun set(param: SetKmcDataParam, data: KmcData) {
        TODO("Not yet implemented")
    }

}