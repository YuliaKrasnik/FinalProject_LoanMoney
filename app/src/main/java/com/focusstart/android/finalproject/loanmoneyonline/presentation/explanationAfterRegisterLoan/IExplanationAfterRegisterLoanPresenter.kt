package com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegisterLoan

interface IExplanationAfterRegisterLoanPresenter {
    fun attachView(view: IExplanationAfterRegisterLoanView)

    fun detachView()

    fun onNavigateToListOfLoansButtonClicked()
}