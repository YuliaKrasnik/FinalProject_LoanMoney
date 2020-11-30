package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.presentation

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBaseView

interface IListOfLoansView : IBaseView {
    fun showLoans(listOfLoans: List<Loan>)

    fun navigateToLoanRegistrationFragment()
}