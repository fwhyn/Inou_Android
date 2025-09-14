package com.telehealth.app.ekmc.core.sensor.kmc.domain.di

import com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase.ExportKmcListUseCase
import com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase.ExportKmcListUseCaseReal
import com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase.GenerateKmcListExcelUseCase
import com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase.GenerateKmcListExcelUseCaseReal
import com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase.GetKmcListUseCase
import com.telehealth.app.ekmc.core.sensor.kmc.domain.usecase.GetKmcListUseCaseReal
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class KmcDomainModule {

    @Binds
    abstract fun bindGetKmcListUseCase(
        getKmcListUseCase: GetKmcListUseCaseReal,
    ): GetKmcListUseCase

    @Binds
    abstract fun bindGenerateKmcListExcelUseCase(
        generateKmcListExcelUseCase: GenerateKmcListExcelUseCaseReal,
    ): GenerateKmcListExcelUseCase

    @Binds
    abstract fun bindExportKmcListUseCase(
        exportKmcListUseCase: ExportKmcListUseCaseReal,
    ): ExportKmcListUseCase
}