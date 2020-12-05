package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.module.TokenRepositoriesModule
import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.SaveBearerTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.repository.TokenRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [AuthenticationRepositoriesModule::class, TokenRepositoriesModule::class])
class AuthenticationUseCasesModule {
    @Provides
    @TokenScope
    fun provideAuthenticationUseCase(loginRepository: LoginRepositoryImpl): AuthenticationUseCase =
            AuthenticationUseCase(loginRepository)

    @Provides
    @TokenScope
    fun provideSaveBearerTokenUseCase(tokenRepositoryImpl: TokenRepositoryImpl): SaveBearerTokenUseCase =
            SaveBearerTokenUseCase(tokenRepositoryImpl)

    @Provides
    @TokenScope
    fun provideRegistrationInAppUseCase(
            loginRepository: LoginRepositoryImpl
    ): RegistrationInAppUseCase = RegistrationInAppUseCase(
            loginRepository
    )
}