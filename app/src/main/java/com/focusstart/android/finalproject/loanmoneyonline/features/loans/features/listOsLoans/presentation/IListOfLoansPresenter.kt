package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.presentation

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.base.presentation.common.IBasePresenter

interface IListOfLoansPresenter : IBasePresenter {
    fun onResume()

    fun clear()

    fun onCreateNewLoanButtonClicked()

    fun getNavigationBundle(loan: Loan): Bundle

}