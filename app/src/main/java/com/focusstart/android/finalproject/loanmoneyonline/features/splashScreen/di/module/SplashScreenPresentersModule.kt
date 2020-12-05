package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase.CheckingBearerTokenAvailabilityUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation.ISplashScreenPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation.SplashScreenPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [SplashScreenUseCasesModule::class])
class SplashScreenPresentersModule {
    @Provides
    @TokenScope
    fun provideSplashScreenPresenter(
            checkingBearerTokenAvailabilityUseCase: CheckingBearerTokenAvailabilityUseCase
    ): ISplashScreenPresenter = SplashScreenPresenterImpl(
            checkingBearerTokenAvailabilityUseCase
    )
}