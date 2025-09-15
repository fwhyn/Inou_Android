package com.fwhyn.app.inou.core.calc.trx.domain.usecase

import com.fwhyn.app.inou.core.calc.trx.domain.model.ExportKmcListParam
import com.fwhyn.lib.baze.common.helper.BaseRunner

abstract class ExportKmcListUseCase : BaseRunner<ExportKmcListParam, Unit>()