package com.fwhyn.app.inou.core.calc.trx.data.model

data class TransactionData(
    val trxTypeData: TrxTypeData,
    val timeStamp: Long,
    val amount: Double,
    val note: String,
) {
    companion object {
        fun default(
            trxTypeData: TrxTypeData = TrxTypeData.Income,
            timeStamp: Long = 1672531199000, // 2023-01-01 00:59:59
            amount: Double = 0.0,
            note: String = ""
        ): TransactionData {
            return TransactionData(
                trxTypeData = trxTypeData,
                timeStamp = timeStamp,
                amount = amount,
                note = note
            )
        }
    }
}

val transactionDataFake = TransactionData(
    trxTypeData = TrxTypeData.Income,
    timeStamp = 1694137800000, // 2023-10-01 12:00:00
    amount = 150.0,
    note = "Salary",
)

val transactionDataListFakes = listOf(
    transactionDataFake,
    TransactionData(
        trxTypeData = TrxTypeData.Outcome,
        timeStamp = 1694226600000, // 2023-10-02 15:30:00
        amount = 50.0,
        note = "Groceries",
    ),
    TransactionData(
        trxTypeData = TrxTypeData.Outcome,
        timeStamp = 1694288400000, // 2023-10-03
        amount = 20.0,
        note = "Transport",
    ),
    TransactionData(
        trxTypeData = TrxTypeData.Income,
        timeStamp = 1694385900000, // 2023-10-04
        amount = 200.0,
        note = "Freelance Work",
    ),
)