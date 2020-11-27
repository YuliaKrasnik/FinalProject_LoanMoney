package com.focusstart.android.finalproject.loanmoneyonline.di

import com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow.IStartWindowPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.startWindow.StartWindowPresenterImpl

object StartWindowPresenterFactory {
    fun create(): IStartWindowPresenter {
        return StartWindowPresenterImpl()
    }
}