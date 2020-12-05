package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBaseView

interface IListOfLoansView : IBaseView {
    fun showLoans(listOfLoans: List<Loan>)

    fun navigateToLoanRegistrationFragment()
}