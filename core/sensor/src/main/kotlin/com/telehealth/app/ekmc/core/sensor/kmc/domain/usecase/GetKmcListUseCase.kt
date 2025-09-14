package com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase

import com.fwhyn.lib.baze.common.helper.BaseRunner
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.GetKmcDomainParam
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.KmcDomain

abstract class GetKmcListUseCase : BaseRunner<GetKmcDomainParam, List<KmcDomain>>()