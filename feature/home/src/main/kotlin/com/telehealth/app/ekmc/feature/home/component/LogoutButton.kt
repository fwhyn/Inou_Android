package com.telehealth.app.ekmc.feature.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.telehealth.app.ekmc.core.common.ui.config.MyTheme
import com.telehealth.app.ekmc.feature.home.R

@Composable
fun LogoutButton(
    modifier: Modifier = Modifier,
    param: LogoutBtnParam,
) {
    Button(
        modifier = modifier.size(40.dp),
        onClick = param.onClick,
        shape = CircleShape,
        contentPadding = PaddingValues(1.dp)
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            imageVector = Icons.AutoMirrored.Filled.Logout,
            contentDescription = stringResource(R.string.logout_button),
        )
    }
}

data class LogoutBtnParam(
    val onClick: () -> Unit,
) {
    companion object {
        fun default(
            onClick: () -> Unit = {},
        ) = LogoutBtnParam(
            onClick = onClick
        )
    }
}


@Composable
fun getStateOfLogoutBtnParam(
    onClick: () -> Unit,
): LogoutBtnParam {
    return LogoutBtnParam(
        onClick = onClick
    )
}

@Composable
@Preview
private fun LogoutButtonPreview() {
    MyTheme {
        LogoutButton(
            param = getStateOfLogoutBtnParam {}
        )
    }
}