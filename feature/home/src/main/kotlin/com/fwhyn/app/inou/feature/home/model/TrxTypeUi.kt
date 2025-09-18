package com.fwhyn.app.inou.feature.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.ui.graphics.vector.ImageVector

enum class TrxTypeUi(val icon: ImageVector) {
    Income(Icons.Default.ArrowDownward),
    Outcome(Icons.Default.ArrowUpward),
}