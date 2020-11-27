package com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegisterLoan

class ExplanationAfterRegisterLoanPresenterImpl : IExplanationAfterRegisterLoanPresenter {
    private var view: IExplanationAfterRegisterLoanView? = null

    override fun attachView(view: IExplanationAfterRegisterLoanView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun onNavigateToListOfLoansButtonClicked() {
        view?.navigateToListOfLoansFragment()
    }
}