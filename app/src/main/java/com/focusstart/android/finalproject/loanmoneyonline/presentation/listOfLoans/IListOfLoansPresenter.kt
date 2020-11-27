package com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans

interface IListOfLoansPresenter {
    fun onResume()

    fun attachView(view: IListOfLoansView)

    fun detachView()

    fun clear()

    fun onCreateNewLoanButtonClicked()
}