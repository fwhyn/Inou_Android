package com.fwhyn.app.inou.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fwhyn.app.inou.core.common.ui.config.MyTheme
import com.fwhyn.app.inou.feature.home.model.TransactionUi
import com.fwhyn.app.inou.feature.home.model.transactionUiFake
import com.fwhyn.lib.baze.compose.component.MySpacer
import com.yeocak.timelineview.TimelineView

@Composable
fun TransactionUiView(
    modifier: Modifier,
    param: TransactionUiViewParam,
) {
    Column(
        modifier = modifier,
    ) {
        var nodeModifier by remember { mutableStateOf(Modifier.height(0.dp)) }
        Row {
            TimelineView.SingleNode(
                modifier = nodeModifier,
                color = MaterialTheme.colorScheme.primary,
                nodeType = param.nodeType,
                nodeSize = 30f,
                isChecked = true,
                isDashed = false
            )

            MySpacer(8.dp)
            val localDensity = (LocalDensity.current)
            Column(
                modifier = Modifier.onGloballyPositioned(
                    onGloballyPositioned = { coordinates ->
                        val itemHeight = with(localDensity) { coordinates.size.height.toDp() }
                        nodeModifier = Modifier.height(itemHeight)
                    }
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .padding(6.dp),
                ) {
                    Text(
                        text = param.transactionUi.timeStamp,
                        color = MaterialTheme.colorScheme.secondary,
                    )

                    MySpacer(6.dp)
                    Text(
                        text = "SpO2: ${param.transactionUi.spoO2.data}${param.transactionUi.spoO2.unit}",
                    )
                    Text(
                        text = "Temperature: ${param.transactionUi.temperature.data}${param.transactionUi.temperature.unit}",
                    )
                    Text(
                        text = "Respiration Rate: ${param.transactionUi.respirationRate.data}${param.transactionUi.respirationRate.unit}",
                    )
                }

                if (param.nodeType != TimelineView.NodeType.LAST) {
                    MySpacer(2.dp)
                    HorizontalDivider(thickness = 1.dp)
                    MySpacer(2.dp)
                }
            }
        }
    }
}

data class TransactionUiViewParam(
    val transactionUi: TransactionUi,
    val nodeType: TimelineView.NodeType,
) {
    companion object {
        fun default(
            transactionUi: TransactionUi = TransactionUi.default(),
            nodeType: TimelineView.NodeType = TimelineView.NodeType.MIDDLE,
        ) = TransactionUiViewParam(
            transactionUi = transactionUi,
            nodeType = nodeType
        )
    }
}

@Preview
@Composable
fun TransactionUiPreview() {
    MyTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TransactionUiView(
                modifier = Modifier.fillMaxWidth(),
                param = TransactionUiViewParam.default(
                    transactionUi = transactionUiFake
                )
            )
        }

    }
}