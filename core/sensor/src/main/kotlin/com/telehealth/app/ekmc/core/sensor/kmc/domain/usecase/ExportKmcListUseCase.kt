package com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase

import com.fwhyn.lib.baze.common.helper.BaseRunner
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.ExportKmcListParam

abstract class ExportKmcListUseCase : BaseRunner<ExportKmcListParam, Unit>()