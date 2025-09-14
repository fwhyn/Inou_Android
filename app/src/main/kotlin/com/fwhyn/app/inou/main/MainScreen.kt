package com.fwhyn.app.inou.main

import android.util.Log
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fwhyn.app.inou.NavigationHost
import com.fwhyn.lib.baze.compose.dialog.CircularProgressDialog
import com.fwhyn.lib.baze.compose.helper.ActivityState
import com.fwhyn.lib.baze.compose.model.CommonState

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    activityState: ActivityState,
    vm: MainVmInterface,
) {
    Box(modifier = modifier) {
        MainHomeView(
            activityState = activityState,
        )

        val activity = LocalActivity.current
        val state by vm.commonProp.state.collectAsStateWithLifecycle()
        when ((state as? CommonState.Dialog<MainState>)?.dat) {
            MainState.Loading -> CircularProgressDialog()
            MainState.Finish -> activity?.finish()
            null -> Log.d("Main Route", "Unhandled State")
        }
    }
}

@Composable
private fun MainHomeView(
    activityState: ActivityState,
) {
    NavigationHost(
        activityState = activityState,
    )
}