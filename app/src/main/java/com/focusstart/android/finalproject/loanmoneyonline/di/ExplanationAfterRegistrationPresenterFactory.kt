package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegistration.ExplanationAfterRegistrationPresenterImpl
import com.focusstart.android.finalproject.loanmoneyonline.presentation.explanationAfterRegistration.IExplanationAfterRegistrationPresenter

object ExplanationAfterRegistrationPresenterFactory {
    fun create(): IExplanationAfterRegistrationPresenter {
        return ExplanationAfterRegistrationPresenterImpl()
    }
}