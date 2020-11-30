package com.focusstart.android.finalproject.loanmoneyonline.di.presenters

import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.SettingsRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module(includes = [RepositoriesModule::class])
class UseCasesModule {
    @Provides
    @PresentersScope
    fun provideAuthenticationUseCase(loginRepository: LoginRepositoryImpl): AuthenticationUseCase =
        AuthenticationUseCase(loginRepository)

    @Provides
    @PresentersScope
    fun provideSaveBearerTokenUseCase(settingsRepositoryImpl: SettingsRepositoryImpl): SaveBearerTokenUseCase =
        SaveBearerTokenUseCase(settingsRepositoryImpl)

    @Provides
    @PresentersScope
    fun provideGetListOfLoansUseCase(loanRepositoryImpl: LoanRepositoryImpl): GetListOfLoansUseCase =
        GetListOfLoansUseCase(loanRepositoryImpl)

    @Provides
    @PresentersScope
    fun provideLoanRegistrationUseCase(
        loanRepositoryImpl: LoanRepositoryImpl
    ): LoanRegistrationUseCase = LoanRegistrationUseCase(
        loanRepositoryImpl
    )

    @Provides
    @PresentersScope
    fun provideGetConditionsLoanUseCase(loanRepositoryImpl: LoanRepositoryImpl): GetConditionsLoanUseCase =
        GetConditionsLoanUseCase(loanRepositoryImpl)

    @Provides
    @PresentersScope
    fun provideRegistrationInAppUseCase(
        loginRepository: LoginRepositoryImpl
    ): RegistrationInAppUseCase = RegistrationInAppUseCase(
        loginRepository
    )

    @Provides
    @PresentersScope
    fun provideCheckingBearerTokenAvailabilityUseCase(
        settingsRepositoryImpl: SettingsRepositoryImpl
    ): CheckingBearerTokenAvailabilityUseCase = CheckingBearerTokenAvailabilityUseCase(
        settingsRepositoryImpl
    )

}