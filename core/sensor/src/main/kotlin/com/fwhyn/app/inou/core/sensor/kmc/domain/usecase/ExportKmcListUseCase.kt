package com.fwhyn.app.inou.core.sensor.kmc.domain.usecase

import com.fwhyn.app.inou.core.sensor.kmc.domain.model.ExportKmcListParam
import com.fwhyn.lib.baze.common.helper.BaseRunner

abstract class ExportKmcListUseCase : BaseRunner<ExportKmcListParam, Unit>()