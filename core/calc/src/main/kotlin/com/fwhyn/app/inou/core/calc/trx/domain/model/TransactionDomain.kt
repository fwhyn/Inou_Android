package com.fwhyn.app.inou.core.calc.trx.domain.model

data class TransactionDomain(
    val trxTypeDomain: TrxTypeDomain,
    val timeStamp: Long,
    val amount: Double,
    val note: String,
)