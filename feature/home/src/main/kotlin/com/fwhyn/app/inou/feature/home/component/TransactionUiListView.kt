package com.fwhyn.app.inou.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fwhyn.app.inou.core.common.ui.config.MyTheme
import com.fwhyn.app.inou.feature.home.model.RespirationRateUi
import com.fwhyn.app.inou.feature.home.model.SpoO2Ui
import com.fwhyn.app.inou.feature.home.model.TemperatureUi
import com.fwhyn.app.inou.feature.home.model.TransactionUi
import com.fwhyn.app.inou.feature.home.model.transactionUiListFake
import com.yeocak.timelineview.TimelineView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun TransactionUiListView(
    modifier: Modifier,
    param: DataStreamViewParam,
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(param.transactionUiList) { index, uiData ->
                val nodeType = when (index) {
                    0 -> TimelineView.NodeType.FIRST
                    param.transactionUiList.lastIndex -> TimelineView.NodeType.LAST
                    else -> TimelineView.NodeType.MIDDLE
                }

                val transactionUiViewParam = TransactionUiViewParam(
                    nodeType = nodeType,
                    transactionUi = uiData,
                )

                TransactionUiView(
                    modifier = Modifier.fillMaxWidth(),
                    param = transactionUiViewParam,
                )
            }
        }
    }
}

data class DataStreamViewParam(
    val transactionUiList: List<TransactionUi>,
) {
    companion object {
        fun default(
            transactionUiLists: List<TransactionUi> = listOf(
                TransactionUi.default(
                    spoO2Ui = SpoO2Ui.default(),
                    temperatureUi = TemperatureUi.default(),
                    respirationRateUi = RespirationRateUi.default()
                )
            ),
        ) = DataStreamViewParam(transactionUiList = transactionUiLists)
    }
}

@Composable
fun getStateOfDataStreamViewParam(
    transactionUiListFlow: StateFlow<List<TransactionUi>>,
): DataStreamViewParam {

    val kmcList: List<TransactionUi> by transactionUiListFlow.collectAsStateWithLifecycle()

    return DataStreamViewParam(
        transactionUiList = kmcList
    )
}

@Composable
@Preview
fun DataStreamViewPreview() {
    val param = getStateOfDataStreamViewParam(
        transactionUiListFlow = MutableStateFlow(transactionUiListFake)
    )

    MyTheme {
        TransactionUiListView(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiary)
                .fillMaxSize()
                .padding(4.dp),
            param = param
        )
    }
}