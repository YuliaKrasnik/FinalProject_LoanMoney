package com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.component

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module.*
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.scope.LoansScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.ui.ListOfLoansFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.ui.LoanProfileFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.ui.LoanRegistrationFragment
import dagger.Subcomponent

@LoansScope
@Subcomponent(modules = [
    LoanPresentersModule::class,
    LoanUseCasesModule::class,
    LoanRepositoriesModule::class,
    LoanSourcesModule::class,
    LoanApiModule::class
])
interface LoansComponent {
    fun inject(fragment: ListOfLoansFragment)
    fun inject(fragment: LoanProfileFragment)
    fun inject(fragment: LoanRegistrationFragment)
}