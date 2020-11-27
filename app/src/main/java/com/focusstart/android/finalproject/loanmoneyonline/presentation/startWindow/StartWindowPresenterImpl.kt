package com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow

class StartWindowPresenterImpl: IStartWindowPresenter {
    private var view: IStartWindowView? = null
    override fun attachView(view: IStartWindowView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun onRegistrationButtonClicked() {
       view?.navigateToRegistrationFragment()
    }

    override fun onAuthenticationButtonClicked() {
        view?.navigateToAuthenticationFragment()
    }
}