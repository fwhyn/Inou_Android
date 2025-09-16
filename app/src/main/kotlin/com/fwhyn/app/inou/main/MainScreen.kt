package com.fwhyn.app.inou.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fwhyn.app.inou.Navigation
import com.fwhyn.app.inou.core.common.ui.helper.CollectLoadingState
import com.fwhyn.lib.baze.compose.helper.ActivityState

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    activityState: ActivityState,
    vm: MainVmInterface,
) {
    vm.commonProp.state.CollectLoadingState()

    Navigation(
        modifier = modifier,
        activityState = activityState,
    )
}