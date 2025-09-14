package com.fwhyn.app.inou.main

import androidx.lifecycle.ViewModel
import com.fwhyn.lib.baze.compose.model.CommonProperties

abstract class MainVmInterface : ViewModel() {
    abstract val commonProp: CommonProperties
}