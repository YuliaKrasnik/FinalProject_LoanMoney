package com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegistration

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface IExplanationAfterRegistrationPresenter : IBasePresenter {
    fun attachView(view: IExplanationAfterRegistrationView)

    fun detachView()

    fun onGetStartedInAppButtonClicked()
}