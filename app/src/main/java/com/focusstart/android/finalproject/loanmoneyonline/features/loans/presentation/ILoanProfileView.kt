package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBaseView

interface ILoanProfileView : IBaseView {
    fun showLoanProfile(
            firstName: String,
            lastName: String,
            phoneNumber: String,
            date: String,
            amount: String,
            period: String,
            percent: String,
            state: String
    )
}