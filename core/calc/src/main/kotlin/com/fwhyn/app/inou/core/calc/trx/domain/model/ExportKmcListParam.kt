package com.fwhyn.app.inou.core.calc.trx.domain.model

import android.net.Uri

data class ExportKmcListParam(
    val kmcList: List<KmcDomain>,
    val dstPath: Uri,
)