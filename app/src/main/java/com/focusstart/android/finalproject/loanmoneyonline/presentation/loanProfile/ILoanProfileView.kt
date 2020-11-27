package com.focusstart.android.finalproject.loanmoneyonline.presentation.loanProfile

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan

interface ILoanProfileView {
    fun showLoanProfile(loan: Loan)
}