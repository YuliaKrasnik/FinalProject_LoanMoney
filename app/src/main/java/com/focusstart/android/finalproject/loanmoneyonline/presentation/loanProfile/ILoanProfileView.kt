package com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile

interface ILoanProfileView {
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