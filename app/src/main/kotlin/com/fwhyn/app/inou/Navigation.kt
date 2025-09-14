package com.fwhyn.app.inou

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.fwhyn.app.inou.feature.home.HOME_ROUTE
import com.fwhyn.app.inou.feature.home.addHomeScreen
import com.fwhyn.lib.baze.compose.helper.ActivityState

@Composable
fun NavigationHost(
    activityState: ActivityState,
) {
    NavHost(
        navController = activityState.navigation,
        startDestination = HOME_ROUTE
    ) {
//        addLoginScreen(
//            activityState = activityState,
//        )
        addHomeScreen(
            activityState = activityState,
        )
    }
}