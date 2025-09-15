package com.fwhyn.app.inou.core.calc.trx.domain.di

import com.fwhyn.app.inou.core.calc.trx.domain.usecase.ExportKmcListUseCase
import com.fwhyn.app.inou.core.calc.trx.domain.usecase.ExportKmcListUseCaseReal
import com.fwhyn.app.inou.core.calc.trx.domain.usecase.GenerateKmcListExcelUseCase
import com.fwhyn.app.inou.core.calc.trx.domain.usecase.GenerateKmcListExcelUseCaseReal
import com.fwhyn.app.inou.core.calc.trx.domain.usecase.GetKmcListUseCase
import com.fwhyn.app.inou.core.calc.trx.domain.usecase.GetKmcListUseCaseReal
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