package com.fwhyn.app.inou.core.calc.trx.domain.usecase

import com.fwhyn.app.inou.core.calc.trx.data.repository.KmcDataRepository
import com.fwhyn.app.inou.core.calc.trx.domain.helper.toData
import com.fwhyn.app.inou.core.calc.trx.domain.helper.toDomain
import com.fwhyn.app.inou.core.calc.trx.domain.model.GetTrxDomainParam
import com.fwhyn.app.inou.core.calc.trx.domain.model.TransactionDomain
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetKmcListUseCaseReal @Inject constructor(
    private val kmcDataRepository: KmcDataRepository,
) : GetKmcListUseCase() {

    private var transactionDomainList = listOf<TransactionDomain>()

    override suspend fun onRunning(
        param: GetTrxDomainParam,
        result: suspend (List<TransactionDomain>) -> Unit,
    ) {
        while (param.isRealTime) {
            result(getKmcDomainList(param))

            delay(1000)
        }

        // If not in real-time mode, just fetch the latest data once
        result(getKmcDomainList(param))
    }

    private suspend fun getKmcDomainList(param: GetTrxDomainParam): List<TransactionDomain> {
        val kmcData = kmcDataRepository.get(param.toData()).toDomain()
        val kmcList = ArrayList(transactionDomainList)

        kmcList.add(0, kmcData)

        if (kmcList.size > param.maxDataList) {
            kmcList.removeAt(kmcList.size - 1)
        }

        transactionDomainList = kmcList

        return kmcList
    }
}