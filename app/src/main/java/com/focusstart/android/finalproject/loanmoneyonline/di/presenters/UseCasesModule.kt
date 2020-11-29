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
    fun provideAuthenticationUseCase(loginRepository: LoginRepositoryImpl): AuthenticationUseCase =
        AuthenticationUseCase(loginRepository)

    @Provides
    fun provideSaveBearerTokenUseCase(settingsRepositoryImpl: SettingsRepositoryImpl): SaveBearerTokenUseCase =
        SaveBearerTokenUseCase(settingsRepositoryImpl)

    @Provides
    fun provideGetListOfLoansUseCase(loanRepositoryImpl: LoanRepositoryImpl): GetListOfLoansUseCase =
        GetListOfLoansUseCase(loanRepositoryImpl)

    @Provides
    fun provideLoanRegistrationUseCase(
        loanRepositoryImpl: LoanRepositoryImpl
    ): LoanRegistrationUseCase = LoanRegistrationUseCase(
        loanRepositoryImpl
    )

    @Provides
    fun provideGetConditionsLoanUseCase(loanRepositoryImpl: LoanRepositoryImpl): GetConditionsLoanUseCase =
        GetConditionsLoanUseCase(loanRepositoryImpl)

    @Provides
    fun provideRegistrationInAppUseCase(
        loginRepository: LoginRepositoryImpl
    ): RegistrationInAppUseCase = RegistrationInAppUseCase(
        loginRepository
    )

    @Provides
    fun provideCheckingBearerTokenAvailabilityUseCase(
        settingsRepositoryImpl: SettingsRepositoryImpl
    ): CheckingBearerTokenAvailabilityUseCase = CheckingBearerTokenAvailabilityUseCase(
        settingsRepositoryImpl
    )

}