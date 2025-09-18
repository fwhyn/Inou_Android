package com.fwhyn.app.inou.feature.home.model

data class TransactionUi(
    val trxTypeUi: TrxTypeUi,
    val timeStamp: String,
    val amount: Double,
    val note: String,
) {
    companion object {
        fun default(
            trxTypeUi: TrxTypeUi = TrxTypeUi.Income,
            timeStamp: String = "1967-01-01 12:00:00",
            amount: Double = 0.0,
            note: String = "-",
        ) = TransactionUi(
            trxTypeUi = trxTypeUi,
            timeStamp = timeStamp,
            amount = amount,
            note = note,
        )
    }
}

val transactionUiFake = TransactionUi(
    trxTypeUi = TrxTypeUi.Income,
    timeStamp = "2023-10-01 12:00:00",
    amount = 150.0,
    note = "Salary",
)

val transactionUiListFake = listOf(
    transactionUiFake,
    TransactionUi(
        trxTypeUi = TrxTypeUi.Outcome,
        timeStamp = "2023-10-02 15:30:00",
        amount = 50.0,
        note = "Groceries",
    ),
    TransactionUi(
        trxTypeUi = TrxTypeUi.Outcome,
        timeStamp = "2023-10-03 09:00:00",
        amount = 20.0,
        note = "Transport",
    ),
    TransactionUi(
        trxTypeUi = TrxTypeUi.Income,
        timeStamp = "2023-10-04 18:45:00",
        amount = 200.0,
        note = "Freelance Work",
    ),
    TransactionUi(
        trxTypeUi = TrxTypeUi.Outcome,
        timeStamp = "2023-10-05 20:15:00",
        amount = 80.0,
        note = "Dining Out",
    ),
)