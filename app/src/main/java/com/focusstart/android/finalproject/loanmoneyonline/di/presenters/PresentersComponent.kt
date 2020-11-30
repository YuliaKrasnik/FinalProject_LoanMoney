package com.focusstart.android.finalproject.loanmoneyonline.di.presenters

import com.focusstart.android.finalproject.loanmoneyonline.ui.*
import com.focusstart.android.finalproject.loanmoneyonline.ui.listOfLoans.ListOfLoansFragment
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