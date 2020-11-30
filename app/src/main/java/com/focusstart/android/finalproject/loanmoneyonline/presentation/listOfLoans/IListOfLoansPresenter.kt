package com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface IListOfLoansPresenter : IBasePresenter {
    fun onResume()

    fun clear()

    fun onCreateNewLoanButtonClicked()

    fun getNavigationBundle(loan: Loan): Bundle

}