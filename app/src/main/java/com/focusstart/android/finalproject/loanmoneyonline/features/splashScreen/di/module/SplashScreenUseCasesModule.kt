package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.module.TokenRepositoriesModule
import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase.CheckingBearerTokenAvailabilityUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.repository.TokenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [TokenRepositoriesModule::class])
class SplashScreenUseCasesModule {
    @Provides
    @TokenScope
    fun provideCheckingBearerTokenAvailabilityUseCase(
            tokenRepositoryImpl: TokenRepositoryImpl
    ): CheckingBearerTokenAvailabilityUseCase = CheckingBearerTokenAvailabilityUseCase(
            tokenRepositoryImpl
    )

}