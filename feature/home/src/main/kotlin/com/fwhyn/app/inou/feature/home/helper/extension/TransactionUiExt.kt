package com.fwhyn.app.inou.feature.home.helper.extension

import com.fwhyn.app.inou.core.calc.trx.domain.model.TransactionDomain
import com.fwhyn.app.inou.core.calc.trx.domain.model.TrxTypeDomain
import com.fwhyn.app.inou.core.common.helper.Util
import com.fwhyn.app.inou.feature.home.model.TransactionUi
import com.fwhyn.app.inou.feature.home.model.TrxTypeUi

fun TransactionUi.toDomain(): TransactionDomain {
    return TransactionDomain(
        trxTypeDomain = when (this.trxTypeUi) {
            TrxTypeUi.Income -> TrxTypeDomain.Income
            TrxTypeUi.Outcome -> TrxTypeDomain.Outcome
        },
        timeStamp = Util.convertDateStringToTimeStamp(this.timeStamp),
        amount = this.amount,
        note = this.note,
    )
}

fun List<TransactionUi>.toDomain(): List<TransactionDomain> {
    return this.map {
        it.toDomain()
    }
}