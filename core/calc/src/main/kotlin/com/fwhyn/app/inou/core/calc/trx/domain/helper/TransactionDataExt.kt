package com.fwhyn.app.inou.core.calc.trx.domain.helper

import com.fwhyn.app.inou.core.calc.trx.data.model.TransactionData
import com.fwhyn.app.inou.core.calc.trx.data.model.TrxTypeData
import com.fwhyn.app.inou.core.calc.trx.domain.model.TransactionDomain
import com.fwhyn.app.inou.core.calc.trx.domain.model.TrxTypeDomain

fun TransactionData.toDomain(): TransactionDomain {
    return TransactionDomain(
        trxTypeDomain = when (this.trxTypeData) {
            TrxTypeData.Income -> TrxTypeDomain.Income
            TrxTypeData.Outcome -> TrxTypeDomain.Outcome
        },
        timeStamp = this.timeStamp,
        amount = this.amount,
        note = this.note,
    )
}