package com.focusstart.android.finalproject.loanmoneyonline.features.settings.presentation

import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IBasePresenter

interface ISettingsPresenter : IBasePresenter {
    fun onLogoutButtonClicked()
    fun onRussianLanguageClicked()
    fun onEnglishLanguageClicked()
    fun clear()
}