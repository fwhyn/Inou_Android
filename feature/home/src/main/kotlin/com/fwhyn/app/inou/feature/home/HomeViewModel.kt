package com.fwhyn.app.inou.feature.home

import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResult
import androidx.lifecycle.viewModelScope
import com.fwhyn.app.inou.core.calc.trx.domain.model.ExportKmcListParam
import com.fwhyn.app.inou.core.calc.trx.domain.model.GetKmcDomainParam
import com.fwhyn.app.inou.core.calc.trx.domain.usecase.ExportKmcListUseCase
import com.fwhyn.app.inou.core.calc.trx.domain.usecase.GetKmcListUseCase
import com.fwhyn.app.inou.core.common.helper.emitEvent
import com.fwhyn.app.inou.core.common.storage.saf.SafUtil
import com.fwhyn.app.inou.core.common.ui.helper.showLoadingDialog
import com.fwhyn.app.inou.feature.home.component.HomeMessageCode
import com.fwhyn.app.inou.feature.home.helper.OpenSafCode
import com.fwhyn.app.inou.feature.home.helper.extension.toDomain
import com.fwhyn.app.inou.feature.home.helper.extension.toUi
import com.fwhyn.app.inou.feature.home.model.HomeEvent
import com.fwhyn.app.inou.feature.home.model.HomeProperties
import com.fwhyn.app.inou.feature.home.model.KmcUi
import com.fwhyn.lib.baze.compose.model.CommonProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getKmcListUseCase: GetKmcListUseCase,
    private val exportKmcListUseCase: ExportKmcListUseCase,
) : HomeVmInterface() {

    private val scope: CoroutineScope
        get() = viewModelScope

    private val event: MutableSharedFlow<HomeEvent> = MutableSharedFlow()
    private val isRealTimeData: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val kmcUiList: MutableStateFlow<List<KmcUi>> = MutableStateFlow(emptyList())

    // ----------------------------------------------------------------
    override val commonProp: CommonProperties = CommonProperties()

    override val properties: HomeProperties = HomeProperties(
        event = event,
        isRealTimeData = isRealTimeData,
        kmcUiList = kmcUiList
    )

    // ----------------------------------------------------------------
    init {
        getKmcUseCase(GetKmcDomainParam.default())
    }

    // ----------------------------------------------------------------
    override fun onConnectOrDisconnect() {
        isRealTimeData.value = !isRealTimeData.value
        getKmcUseCase(GetKmcDomainParam.default(isRealTime = isRealTimeData.value))
    }

    override fun onExportData() {
        event.emitEvent(scope, HomeEvent.OpenSaf(OpenSafCode.ExportKmcList))
    }

    override fun onCreateFileResult(result: ActivityResult) {
        checkForExportRequest(
            resultCode = result.resultCode,
            data = result.data
        )
    }

    // ----------------------------------------------------------------
    private fun getKmcUseCase(param: GetKmcDomainParam) {
        getKmcListUseCase.setForcedCancelPreviousActiveJob(true)
        getKmcListUseCase.invoke(
            scope = scope,
            onFetchParam = { param },
            onOmitResult = { res ->
                res.onSuccess { kmcListDomain ->
                    kmcUiList.value = kmcListDomain.toUi()
                }.onFailure {
                    event.emit(HomeEvent.Notify(HomeMessageCode.GetKmcListError))
                }
            },
        )

    }

    private fun checkForExportRequest(
        resultCode: Int,
        data: Intent?,
    ) {
        val uri: Uri? = SafUtil.getGrantedPathOrNull(
            resultCode = resultCode,
            resultData = data
        )

        uri?.let {
            val tag = exportKmcListUseCase.getId()
            exportKmcListUseCase.invoke(
                scope = scope,
                onStart = { commonProp.showLoadingDialog(tag) },
                onFetchParam = {
                    val kmcList = properties.kmcUiList.value
                    ExportKmcListParam(kmcList.toDomain(), uri)
                },
                onOmitResult = { res ->
                    res.onSuccess {
                        event.emit(HomeEvent.Notify(HomeMessageCode.ExportSuccess))
                    }.onFailure {
                        event.emit(HomeEvent.Notify(HomeMessageCode.ExportError))
                    }
                },
                onFinish = { commonProp.dismissDialog(tag) }
            )
        }
    }
}