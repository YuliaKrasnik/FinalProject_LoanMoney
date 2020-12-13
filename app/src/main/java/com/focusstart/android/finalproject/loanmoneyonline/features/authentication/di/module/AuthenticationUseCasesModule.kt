package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.scope.AuthenticationScope
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.SaveBearerTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.core.data.repository.TokenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [AuthenticationRepositoriesModule::class])
class AuthenticationUseCasesModule {
    @Provides
    @AuthenticationScope
    fun provideAuthenticationUseCase(loginRepository: LoginRepositoryImpl): AuthenticationUseCase =
            AuthenticationUseCase(loginRepository)

    @Provides
    @AuthenticationScope
    fun provideSaveBearerTokenUseCase(tokenRepositoryImpl: TokenRepositoryImpl): SaveBearerTokenUseCase =
            SaveBearerTokenUseCase(tokenRepositoryImpl)

    @Provides
    @AuthenticationScope
    fun provideRegistrationInAppUseCase(
            loginRepository: LoginRepositoryImpl
    ): RegistrationInAppUseCase = RegistrationInAppUseCase(
            loginRepository
    )
}