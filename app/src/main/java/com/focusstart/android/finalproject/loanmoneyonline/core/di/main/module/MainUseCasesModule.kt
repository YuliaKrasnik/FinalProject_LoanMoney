package com.focusstart.android.finalproject.loanmoneyonline.core.di.main.module

import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.SettingsRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.di.main.scope.MainScope
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.ListeningLanguageUseCase
import dagger.Module
import dagger.Provides

@Module
class MainUseCasesModule {
    @MainScope
    @Provides
    fun provideListeningLanguageUseCase(settingsRepositoryImpl: SettingsRepositoryImpl): ListeningLanguageUseCase =
        ListeningLanguageUseCase(settingsRepositoryImpl)

}