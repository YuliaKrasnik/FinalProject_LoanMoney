package com.focusstart.android.finalproject.loanmoneyonline.features.explanations.di.component

import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.di.module.ExplanationPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.di.scope.ExplanationsScope
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterLoan.ui.ExplanationAfterRegisterLoanFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.ui.ExplanationAfterRegistrationFragment
import dagger.Subcomponent

@ExplanationsScope
@Subcomponent(modules = [ExplanationPresentersModule::class])
interface ExplanationsComponent {
    fun inject(fragment: ExplanationAfterRegisterLoanFragment)
    fun inject(fragment: ExplanationAfterRegistrationFragment)
}