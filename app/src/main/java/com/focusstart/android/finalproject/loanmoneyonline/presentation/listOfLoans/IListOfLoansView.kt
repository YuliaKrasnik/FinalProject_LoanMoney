package com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan

interface IListOfLoansView {
    fun showLoans(listOfLoans: List<Loan>)

    fun navigateToLoanRegistrationFragment()
}