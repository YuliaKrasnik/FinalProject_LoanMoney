package com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegistration

class ExplanationAfterRegistrationPresenterImpl : IExplanationAfterRegistrationPresenter {
    private var view: IExplanationAfterRegistrationView? = null

    override fun detachView() {
        this.view = null
    }

    override fun onGetStartedInAppButtonClicked() {
        view?.navigateToLoanRegistrationFragment()
    }

    override fun <T> attachView(view: T) {
        this.view = view as IExplanationAfterRegistrationView
    }


}