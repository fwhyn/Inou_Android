package com.fwhyn.app.inou.core.calc.kmc.domain.model

import android.net.Uri

data class ExportKmcListParam(
    val kmcList: List<KmcDomain>,
    val dstPath: Uri,
)