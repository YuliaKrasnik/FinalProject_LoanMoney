package com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow

class StartWindowPresenterImpl : IStartWindowPresenter {
    private var view: IStartWindowView? = null

    override fun detachView() {
        this.view = null
    }

    override fun onRegistrationButtonClicked() {
        view?.navigateToRegistrationFragment()
    }

    override fun onAuthenticationButtonClicked() {
        view?.navigateToAuthenticationFragment()
    }

    override fun <T> attachView(view: T) {
        this.view = view as IStartWindowView
    }
}