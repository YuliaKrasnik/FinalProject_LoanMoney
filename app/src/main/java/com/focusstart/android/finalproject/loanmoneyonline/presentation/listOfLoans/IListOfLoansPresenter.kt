package com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans

import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan

interface IListOfLoansPresenter {
    fun onResume()

    fun attachView(view: IListOfLoansView)

    fun detachView()

    fun clear()

    fun onCreateNewLoanButtonClicked()

    fun getNavigationBundle(loan: Loan): Bundle

}