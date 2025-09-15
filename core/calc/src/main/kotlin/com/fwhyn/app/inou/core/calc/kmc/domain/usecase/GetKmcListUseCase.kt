package com.fwhyn.app.inou.core.calc.kmc.domain.usecase

import com.fwhyn.app.inou.core.calc.kmc.domain.model.GetKmcDomainParam
import com.fwhyn.app.inou.core.calc.kmc.domain.model.KmcDomain
import com.fwhyn.lib.baze.common.helper.BaseRunner

abstract class GetKmcListUseCase : BaseRunner<GetKmcDomainParam, List<KmcDomain>>()