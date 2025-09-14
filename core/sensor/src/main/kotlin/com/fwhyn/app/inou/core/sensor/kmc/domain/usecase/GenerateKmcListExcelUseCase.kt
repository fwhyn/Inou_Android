package com.fwhyn.app.inou.core.sensor.kmc.domain.usecase

import com.fwhyn.app.inou.core.sensor.kmc.domain.model.GenerateKmcListExcelParam
import com.fwhyn.lib.baze.common.helper.BaseRunner
import org.apache.poi.xssf.usermodel.XSSFWorkbook

abstract class GenerateKmcListExcelUseCase : BaseRunner<GenerateKmcListExcelParam, XSSFWorkbook>()