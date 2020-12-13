package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.SetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.scope.SplashScreenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase.CheckingBearerTokenAvailabilityUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation.ISplashScreenPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation.SplashScreenPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [SplashScreenUseCasesModule::class])
class SplashScreenPresentersModule {
    @Provides
    @SplashScreenScope
    fun provideSplashScreenPresenter(
            checkingBearerTokenAvailabilityUseCase: CheckingBearerTokenAvailabilityUseCase,
            setFlagFirstLaunchAppUseCase: SetFlagFirstLaunchAppUseCase
    ): ISplashScreenPresenter = SplashScreenPresenterImpl(
            checkingBearerTokenAvailabilityUseCase,
            setFlagFirstLaunchAppUseCase
    )
}