package com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegisterLoan

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface IExplanationAfterRegisterLoanPresenter : IBasePresenter {
    fun attachView(view: IExplanationAfterRegisterLoanView)

    fun detachView()

    fun onNavigateToListOfLoansButtonClicked()
}