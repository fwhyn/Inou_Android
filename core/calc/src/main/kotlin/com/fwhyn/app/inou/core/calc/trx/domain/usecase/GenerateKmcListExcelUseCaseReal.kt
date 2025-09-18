package com.fwhyn.app.inou.core.calc.trx.domain.usecase

import com.fwhyn.app.inou.core.calc.trx.domain.model.GenerateKmcListExcelParam
import com.fwhyn.app.inou.core.calc.trx.domain.model.TransactionDomain
import com.fwhyn.app.inou.core.common.helper.Util
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import javax.inject.Inject

class GenerateKmcListExcelUseCaseReal @Inject constructor() : GenerateKmcListExcelUseCase() {

    override suspend fun onRunning(param: GenerateKmcListExcelParam, result: suspend (XSSFWorkbook) -> Unit) {
        val _result = generateExcelWorkBook(param.kmcList)
        result(_result)
    }

    private fun generateExcelWorkBook(dataList: List<TransactionDomain>): XSSFWorkbook {
        val workbook = XSSFWorkbook()
        val sheet = workbook.createSheet("TransactionData")

        // Header row
        val header = sheet.createRow(0)
        header.createCell(0).setCellValue("Timestamp")
        header.createCell(1).setCellValue("Type")
        header.createCell(2).setCellValue("Amount")
        header.createCell(3).setCellValue("Note")

        // Data rows
        dataList.forEachIndexed { index, data ->
            val row = sheet.createRow(index + 1)
            row.createCell(0).setCellValue(Util.convertTimeStampToDateString(data.timeStamp))
            row.createCell(1).setCellValue(data.trxTypeDomain.name)
            row.createCell(2).setCellValue(data.amount)
            row.createCell(3).setCellValue(data.note)
        }

        return workbook
    }
}