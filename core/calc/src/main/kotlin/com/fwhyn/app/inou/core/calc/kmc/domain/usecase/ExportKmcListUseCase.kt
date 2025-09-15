package com.fwhyn.app.inou.core.calc.kmc.domain.usecase

import com.fwhyn.app.inou.core.calc.kmc.domain.model.ExportKmcListParam
import com.fwhyn.lib.baze.common.helper.BaseRunner

abstract class ExportKmcListUseCase : BaseRunner<ExportKmcListParam, Unit>()