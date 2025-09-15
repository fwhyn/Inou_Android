package com.fwhyn.app.inou.core.calc.kmc.domain.usecase

import com.fwhyn.app.inou.core.calc.kmc.domain.model.GenerateKmcListExcelParam
import com.fwhyn.lib.baze.common.helper.BaseRunner
import org.apache.poi.xssf.usermodel.XSSFWorkbook

abstract class GenerateKmcListExcelUseCase : BaseRunner<GenerateKmcListExcelParam, XSSFWorkbook>()