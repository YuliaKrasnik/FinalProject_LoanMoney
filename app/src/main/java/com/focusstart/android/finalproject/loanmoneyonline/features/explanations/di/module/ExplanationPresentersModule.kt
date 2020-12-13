package com.focusstart.android.finalproject.loanmoneyonline.features.explanations.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.di.scope.ExplanationsScope
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterLoan.presentation.ExplanationAfterRegisterLoanPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterLoan.presentation.IExplanationAfterRegisterLoanPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.presentation.ExplanationAfterRegistrationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.explanationAfterRegisterUser.presentation.IExplanationAfterRegistrationPresenter
import dagger.Module
import dagger.Provides

@Module
class ExplanationPresentersModule {
    @Provides
    @ExplanationsScope
    fun provideExplanationAfterRegisterLoanPresenter(): IExplanationAfterRegisterLoanPresenter =
            ExplanationAfterRegisterLoanPresenterImpl()

    @Provides
    @ExplanationsScope
    fun provideExplanationAfterRegistrationPresenter(): IExplanationAfterRegistrationPresenter =
            ExplanationAfterRegistrationPresenterImpl()
}