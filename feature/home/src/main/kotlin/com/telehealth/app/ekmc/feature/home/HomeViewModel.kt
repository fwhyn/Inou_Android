package com.telehealth.app.ekmc.feature.home

import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResult
import androidx.lifecycle.viewModelScope
import com.fwhyn.lib.baze.compose.model.CommonProperties
import com.telehealth.app.ekmc.core.common.helper.emitEvent
import com.telehealth.app.ekmc.core.common.storage.saf.SafUtil
import com.telehealth.app.ekmc.core.common.ui.helper.showLoadingDialog
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.ExportKmcListParam
import com.telehealth.app.ekmc.core.sensor.kmc.domain.model.GetKmcDomainParam
import com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase.ExportKmcListUseCase
import com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase.GetKmcListUseCase
import com.telehealth.app.ekmc.feature.home.component.HomeMessageCode
import com.telehealth.app.ekmc.feature.home.helper.OpenSafCode
import com.telehealth.app.ekmc.feature.home.helper.extension.toDomain
import com.telehealth.app.ekmc.feature.home.helper.extension.toUi
import com.telehealth.app.ekmc.feature.home.model.HomeEvent
import com.telehealth.app.ekmc.feature.home.model.HomeProperties
import com.telehealth.app.ekmc.feature.home.model.KmcUi
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