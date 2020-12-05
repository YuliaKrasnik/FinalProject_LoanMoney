package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.SaveBearerTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation.AuthenticationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation.IAuthenticationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation.IRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation.RegistrationPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [AuthenticationUseCasesModule::class])
class AuthenticationPresentersModule {

    @Provides
    @TokenScope
    fun provideAuthenticationPresenter(
            authenticationInAppUseCase: AuthenticationUseCase,
            saveBearerTokenInPreferencesUseCase: SaveBearerTokenUseCase
    ): IAuthenticationPresenter = AuthenticationPresenterImpl(
            authenticationInAppUseCase,
            saveBearerTokenInPreferencesUseCase
    )

    @Provides
    @TokenScope
    fun provideRegistrationPresenter(
            registrationInAppUseCase: RegistrationInAppUseCase
    ): IRegistrationPresenter = RegistrationPresenterImpl(
            registrationInAppUseCase
    )


}