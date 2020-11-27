package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegisterLoan.ExplanationAfterRegisterLoanPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegisterLoan.IExplanationAfterRegisterLoanPresenter

object ExplanationAfterRegisterLoanPresenterFactory {
    fun create(): IExplanationAfterRegisterLoanPresenter {
        return ExplanationAfterRegisterLoanPresenterImpl()
    }
}