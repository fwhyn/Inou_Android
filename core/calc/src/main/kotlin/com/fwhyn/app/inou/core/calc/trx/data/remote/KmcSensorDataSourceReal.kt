package com.fwhyn.app.inou.core.calc.trx.data.remote

import com.fwhyn.app.inou.core.calc.trx.data.model.KmcData
import com.fwhyn.app.inou.core.calc.trx.data.model.KmccalcParam

class KmccalcDataSourceReal : KmccalcDataSource {

    override suspend fun get(param: KmccalcParam): KmcData {
        TODO("Implement the method to fetch KmcData from the remote source")
    }
}