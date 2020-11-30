package com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.domain.usecase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.domain.usecase.SaveBearerTokenUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.presentation.AuthenticationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.presentation.IAuthenticationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.registration.domain.usecase.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterLoan.presentation.ExplanationAfterRegisterLoanPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterLoan.presentation.IExplanationAfterRegisterLoanPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.presentation.ExplanationAfterRegistrationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.presentation.IExplanationAfterRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.presentation.IListOfLoansPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.presentation.ListOfLoansPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.loanProfile.presentation.ILoanProfilePresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.loanProfile.presentation.LoanProfilePresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.presentation.ILoanRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.presentation.LoanRegistrationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.registration.presentation.IRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.registration.presentation.RegistrationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.scope.PresentersScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.domain.usecase.GetListOfLoansUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.domain.usecase.GetConditionsLoanUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.domain.usecase.LoanRegistrationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation.ISplashScreenPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation.SplashScreenPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation.IStartWindowPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation.StartWindowPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase.CheckingBearerTokenAvailabilityUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [UseCasesModule::class])
class PresentersModule {
    @Provides
    @PresentersScope
    fun provideAuthenticationPresenter(
            authenticationInAppUseCase: AuthenticationUseCase,
            saveBearerTokenInPreferencesUseCase: SaveBearerTokenUseCase
    ): IAuthenticationPresenter = AuthenticationPresenterImpl(
        authenticationInAppUseCase,
        saveBearerTokenInPreferencesUseCase
    )

    @Provides
    @PresentersScope
    fun provideExplanationAfterRegisterLoanPresenter(): IExplanationAfterRegisterLoanPresenter =
        ExplanationAfterRegisterLoanPresenterImpl()

    @Provides
    @PresentersScope
    fun provideExplanationAfterRegistrationPresenter(): IExplanationAfterRegistrationPresenter =
        ExplanationAfterRegistrationPresenterImpl()

    @Provides
    @PresentersScope
    fun provideListOfLoansPresenter(
        getListOfLoansUseCase: GetListOfLoansUseCase
    ): IListOfLoansPresenter = ListOfLoansPresenterImpl(
        getListOfLoansUseCase
    )

    @Provides
    @PresentersScope
    fun provideLoanProfilePresenter(): ILoanProfilePresenter = LoanProfilePresenterImpl()

    @Provides
    @PresentersScope
    fun provideLoanRegistrationPresenter(
            loanRegistrationUseCase: LoanRegistrationUseCase,
            getConditionsLoanUseCase: GetConditionsLoanUseCase
    ): ILoanRegistrationPresenter = LoanRegistrationPresenterImpl(
        loanRegistrationUseCase,
        getConditionsLoanUseCase
    )

    @Provides
    @PresentersScope
    fun provideRegistrationPresenter(
        registrationInAppUseCase: RegistrationInAppUseCase
    ): IRegistrationPresenter = RegistrationPresenterImpl(
        registrationInAppUseCase
    )

    @Provides
    @PresentersScope
    fun provideSplashScreenPresenter(
        checkingBearerTokenAvailabilityUseCase: CheckingBearerTokenAvailabilityUseCase
    ): ISplashScreenPresenter = SplashScreenPresenterImpl(
        checkingBearerTokenAvailabilityUseCase
    )

    @Provides
    @PresentersScope
    fun provideStartWindowPresenter(): IStartWindowPresenter = StartWindowPresenterImpl()
}