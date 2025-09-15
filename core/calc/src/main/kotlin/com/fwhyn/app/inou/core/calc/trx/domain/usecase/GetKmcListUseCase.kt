package com.fwhyn.app.inou.core.calc.trx.domain.usecase

import com.fwhyn.app.inou.core.calc.trx.domain.model.GetKmcDomainParam
import com.fwhyn.app.inou.core.calc.trx.domain.model.KmcDomain
import com.fwhyn.lib.baze.common.helper.BaseRunner

abstract class GetKmcListUseCase : BaseRunner<GetKmcDomainParam, List<KmcDomain>>()