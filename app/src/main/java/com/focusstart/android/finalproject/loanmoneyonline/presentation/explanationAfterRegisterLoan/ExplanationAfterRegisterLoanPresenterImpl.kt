package com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegisterLoan

class ExplanationAfterRegisterLoanPresenterImpl : IExplanationAfterRegisterLoanPresenter {
    private var view: IExplanationAfterRegisterLoanView? = null

    override fun detachView() {
        this.view = null
    }

    override fun onNavigateToListOfLoansButtonClicked() {
        view?.navigateToListOfLoansFragment()
    }

    override fun <T> attachView(view: T) {
        this.view = view as IExplanationAfterRegisterLoanView
    }
}