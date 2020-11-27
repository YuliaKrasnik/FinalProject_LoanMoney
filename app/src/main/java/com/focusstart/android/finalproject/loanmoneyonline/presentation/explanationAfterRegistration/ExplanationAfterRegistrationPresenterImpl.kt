package com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegistration

class ExplanationAfterRegistrationPresenterImpl : IExplanationAfterRegistrationPresenter {
    private var view: IExplanationAfterRegistrationView? = null

    override fun attachView(view: IExplanationAfterRegistrationView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun onGetStartedInAppButtonClicked() {
        view?.navigateToLoanRegistrationFragment()
    }


}