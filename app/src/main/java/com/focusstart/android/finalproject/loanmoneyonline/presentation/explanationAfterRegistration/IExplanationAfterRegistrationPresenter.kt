package com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegistration

interface IExplanationAfterRegistrationPresenter {
    fun attachView(view: IExplanationAfterRegistrationView)

    fun detachView()

    fun onGetStartedInAppButtonClicked()
}