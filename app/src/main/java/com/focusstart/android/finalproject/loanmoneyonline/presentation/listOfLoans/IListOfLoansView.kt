package com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBaseView

interface IListOfLoansView : IBaseView {
    fun showLoans(listOfLoans: List<Loan>)

    fun navigateToLoanRegistrationFragment()
}