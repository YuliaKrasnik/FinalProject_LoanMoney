package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.loanProfile.presentation

import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBaseView

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