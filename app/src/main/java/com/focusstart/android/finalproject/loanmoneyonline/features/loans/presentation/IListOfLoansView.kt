package com.focusstart.android.finalproject.loanmoneyonline.features.loans.presentation

import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBaseView
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan

interface IListOfLoansView : IBaseView {
    fun showLoans(listOfLoans: List<Loan>)

    fun navigateToLoanRegistrationFragment()

    fun setRefreshing(flag: Boolean)
}