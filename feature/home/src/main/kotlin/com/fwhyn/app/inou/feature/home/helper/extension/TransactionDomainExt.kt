package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.trx.domain.model.TransactionDomain
import com.fwhyn.app.inou.core.calc.trx.domain.model.TrxTypeDomain
import com.fwhyn.app.inou.core.common.helper.Util
import com.fwhyn.app.inou.feature.home.model.TransactionUi
import com.fwhyn.app.inou.feature.home.model.TrxTypeUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun TransactionDomain.toUi(): TransactionUi {
    return TransactionUi(
        trxTypeUi = when (this.trxTypeDomain) {
            TrxTypeDomain.Income -> TrxTypeUi.Income
            TrxTypeDomain.Outcome -> TrxTypeUi.Outcome
        },
        timeStamp = Util.convertTimeStampToDateString(this.timeStamp),
        amount = this.amount,
        note = this.note,
    )
}

fun List<TransactionDomain>.toUi(): List<TransactionUi> {
    return this.map { it.toUi() }
}

fun Flow<List<TransactionDomain>>.toUi(): Flow<List<TransactionUi>> {
    return this.map { kmcList -> kmcList.toUi() }
}