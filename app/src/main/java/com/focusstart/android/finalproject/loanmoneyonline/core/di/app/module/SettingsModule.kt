package com.focusstart.android.finalproject.loanmoneyonline.core.di.app.module

import com.focusstart.android.finalproject.loanmoneyonline.core.data.datasource.SettingsDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.SettingsProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.SettingsRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.di.app.scope.ApplicationScope
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.GetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.SetFlagFirstLaunchAppUseCase
import dagger.Module
import dagger.Provides

@Module
class SettingsModule {
    @Provides
    @ApplicationScope
    fun provideSettingsRepository(settingsDataSourceImpl: SettingsDataSourceImpl): SettingsRepositoryImpl =
            SettingsRepositoryImpl(settingsDataSourceImpl)

    @Provides
    @ApplicationScope
    fun provideSettingsSource(settingsProvider: SettingsProviderImpl): SettingsDataSourceImpl =
            SettingsDataSourceImpl(settingsProvider)

    @Provides
    @ApplicationScope
    fun provideGetFlagFirstLaunchAppUseCase(settingsRepository: SettingsRepositoryImpl): GetFlagFirstLaunchAppUseCase =
            GetFlagFirstLaunchAppUseCase(settingsRepository)

    @Provides
    @ApplicationScope
    fun provideSetFlagFirstLaunchAppUseCase(settingsRepository: SettingsRepositoryImpl): SetFlagFirstLaunchAppUseCase =
            SetFlagFirstLaunchAppUseCase(settingsRepository)
}