package com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase

import com.fwhyn.lib.baze.common.helper.BaseRunner
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.GenerateKmcListExcelParam
import org.apache.poi.xssf.usermodel.XSSFWorkbook

abstract class GenerateKmcListExcelUseCase : BaseRunner<GenerateKmcListExcelParam, XSSFWorkbook>()