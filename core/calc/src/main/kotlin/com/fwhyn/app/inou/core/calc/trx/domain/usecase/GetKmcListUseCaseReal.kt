package com.fwhyn.app.inou.core.calc.trx.domain.usecase

import com.fwhyn.app.inou.core.calc.trx.data.repository.KmcDataRepository
import com.fwhyn.app.inou.core.calc.trx.domain.helper.toData
import com.fwhyn.app.inou.core.calc.trx.domain.helper.toDomain
import com.fwhyn.app.inou.core.calc.trx.domain.model.GetKmcDomainParam
import com.fwhyn.app.inou.core.calc.trx.domain.model.KmcDomain
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetKmcListUseCaseReal @Inject constructor(
    private val kmcDataRepository: KmcDataRepository,
) : GetKmcListUseCase() {

    private var kmcDomainList = listOf<KmcDomain>()

    override suspend fun onRunning(
        param: GetKmcDomainParam,
        result: suspend (List<KmcDomain>) -> Unit,
    ) {
        while (param.isRealTime) {
            result(getKmcDomainList(param))

            delay(1000)
        }

        // If not in real-time mode, just fetch the latest data once
        result(getKmcDomainList(param))
    }

    private suspend fun getKmcDomainList(param: GetKmcDomainParam): List<KmcDomain> {
        val kmcData = kmcDataRepository.get(param.toData()).toDomain()
        val kmcList = ArrayList(kmcDomainList)

        kmcList.add(0, kmcData)

        if (kmcList.size > param.maxDataList) {
            kmcList.removeAt(kmcList.size - 1)
        }

        kmcDomainList = kmcList

        return kmcList
    }
}