package com.telehealth.app.ekmc

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.fwhyn.lib.baze.compose.helper.ActivityState
import com.telehealth.app.ekmc.feature.home.HOME_ROUTE
import com.telehealth.app.ekmc.feature.home.addHomeScreen

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