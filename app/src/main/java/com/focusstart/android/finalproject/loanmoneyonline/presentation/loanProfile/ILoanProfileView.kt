package com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBaseView

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