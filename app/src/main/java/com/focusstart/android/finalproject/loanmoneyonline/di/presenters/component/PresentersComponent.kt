package com.focusstart.android.finalproject.loanmoneyonline.di.presenters.component

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.authentication.ui.AuthenticationFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.features.registration.ui.RegistrationFragment
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module.PresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module.RepositoriesModule
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module.SourcesModule
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module.UseCasesModule
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.scope.PresentersScope
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterLoan.ui.ExplanationAfterRegisterLoanFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.ui.ExplanationAfterRegistrationFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.loanProfile.ui.LoanProfileFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.registrationLoan.ui.LoanRegistrationFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.ui.ListOfLoansFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.ui.SplashScreenFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.ui.StartFragment
import dagger.Subcomponent
@PresentersScope
@Subcomponent(modules = [PresentersModule::class, UseCasesModule::class, RepositoriesModule::class, SourcesModule::class])
interface PresentersComponent {
    fun inject(fragment: AuthenticationFragment)
    fun inject(fragment: ExplanationAfterRegisterLoanFragment)
    fun inject(fragment: ExplanationAfterRegistrationFragment)
    fun inject(fragment: ListOfLoansFragment)
    fun inject(fragment: LoanProfileFragment)
    fun inject(fragment: LoanRegistrationFragment)
    fun inject(fragment: RegistrationFragment)
    fun inject(fragment: SplashScreenFragment)
    fun inject(fragment: StartFragment)
}