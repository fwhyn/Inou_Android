package com.fwhyn.app.inou.main

import com.fwhyn.lib.baze.compose.model.CommonProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : MainVmInterface() {

    override val commonProp: CommonProperties = CommonProperties()
}