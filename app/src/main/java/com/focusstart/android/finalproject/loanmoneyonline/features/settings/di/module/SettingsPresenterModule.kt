package com.focusstart.android.finalproject.loanmoneyonline.features.settings.di.module

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.SetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.di.scope.SettingsScope
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.DeleteCachedLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.DeleteTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.domain.useCase.SetLanguageUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.presentation.ISettingsPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.presentation.SettingsPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [SettingsUseCasesModule::class])
class SettingsPresenterModule {
    @Provides
    @SettingsScope
    fun provideSettingsPresenter(
            setLanguageUseCase: SetLanguageUseCase,
            deleteTokenUseCase: DeleteTokenUseCase,
            deleteCachedLoansUseCase: DeleteCachedLoansUseCase,
            setFlagFirstLaunchAppUseCase: SetFlagFirstLaunchAppUseCase
    ): ISettingsPresenter = SettingsPresenterImpl(
            setLanguageUseCase,
            deleteTokenUseCase,
            deleteCachedLoansUseCase,
            setFlagFirstLaunchAppUseCase
    )

}