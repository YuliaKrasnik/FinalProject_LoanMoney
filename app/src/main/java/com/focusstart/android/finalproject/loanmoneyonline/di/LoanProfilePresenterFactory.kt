package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile.ILoanProfilePresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile.LoanProfilePresenterImpl

object LoanProfilePresenterFactory {
    fun create(): ILoanProfilePresenter {
        return LoanProfilePresenterImpl()
    }
}