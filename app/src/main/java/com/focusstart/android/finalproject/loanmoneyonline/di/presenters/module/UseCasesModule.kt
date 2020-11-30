package com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.domain.usecase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.domain.usecase.SaveBearerTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.registration.domain.usecase.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.scope.PresentersScope
import com.focusstart.android.finalproject.loanmoneyonline.features.token.data.repository.TokenRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.domain.usecase.GetListOfLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.domain.usecase.GetConditionsLoanUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.domain.usecase.LoanRegistrationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase.CheckingBearerTokenAvailabilityUseCase
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
    fun provideSaveBearerTokenUseCase(tokenRepositoryImpl: TokenRepositoryImpl): SaveBearerTokenUseCase =
        SaveBearerTokenUseCase(tokenRepositoryImpl)

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
            tokenRepositoryImpl: TokenRepositoryImpl
    ): CheckingBearerTokenAvailabilityUseCase = CheckingBearerTokenAvailabilityUseCase(
        tokenRepositoryImpl
    )

}