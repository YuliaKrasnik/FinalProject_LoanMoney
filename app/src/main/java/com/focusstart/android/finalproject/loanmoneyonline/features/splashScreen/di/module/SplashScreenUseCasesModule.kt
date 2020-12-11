package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.scope.SplashScreenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase.CheckingBearerTokenAvailabilityUseCase
import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.TokenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class SplashScreenUseCasesModule {
    @Provides
    @SplashScreenScope
    fun provideCheckingBearerTokenAvailabilityUseCase(
            tokenRepositoryImpl: TokenRepositoryImpl
    ): CheckingBearerTokenAvailabilityUseCase = CheckingBearerTokenAvailabilityUseCase(
            tokenRepositoryImpl
    )

}