package com.telehealth.app.ekmc.feature.home

import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import com.fwhyn.lib.baze.compose.model.CommonProperties
import com.telehealth.app.ekmc.feature.home.model.HomeProperties

abstract class HomeVmInterface : ViewModel() {

    abstract val commonProp: CommonProperties
    abstract val properties: HomeProperties

    open fun onLogout() {}
    open fun onConnectOrDisconnect() {}
    open fun onExportData() {}
    open fun onCreateFileResult(result: ActivityResult) {}
}