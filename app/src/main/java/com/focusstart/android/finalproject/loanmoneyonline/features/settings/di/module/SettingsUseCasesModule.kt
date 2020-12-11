package com.focusstart.android.finalproject.loanmoneyonline.features.settings.di.module

import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.SettingsRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.di.scope.SettingsScope
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.DeleteCachedLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.DeleteTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.SetLanguageUseCase
import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.TokenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class SettingsUseCasesModule {
    @Provides
    @SettingsScope
    fun provideSetLanguageUseCase(
            settingsRepository: SettingsRepositoryImpl
    ): SetLanguageUseCase = SetLanguageUseCase(
            settingsRepository
    )

    @Provides
    @SettingsScope
    fun provideDeleteTokenUseCase(
            tokenRepository: TokenRepositoryImpl
    ): DeleteTokenUseCase = DeleteTokenUseCase(
            tokenRepository
    )

    @Provides
    @SettingsScope
    fun provideDeleteCachedLoansUseCase(
            loansRepository: LoanRepositoryImpl
    ): DeleteCachedLoansUseCase = DeleteCachedLoansUseCase(loansRepository)

}