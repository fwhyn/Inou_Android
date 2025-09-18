package com.fwhyn.app.inou.core.calc.trx.domain.usecase

import com.fwhyn.app.inou.core.calc.trx.domain.model.GetTrxDomainParam
import com.fwhyn.app.inou.core.calc.trx.domain.model.TransactionDomain
import com.fwhyn.lib.baze.common.helper.BaseRunner

abstract class GetKmcListUseCase : BaseRunner<GetTrxDomainParam, List<TransactionDomain>>()