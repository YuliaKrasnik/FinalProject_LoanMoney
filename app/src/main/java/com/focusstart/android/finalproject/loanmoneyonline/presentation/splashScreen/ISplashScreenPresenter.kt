package com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen

import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.IBasePresenter

interface ISplashScreenPresenter : IBasePresenter {
    fun onResume()

    fun attachView(view: ISplashScreenView)

    fun detachView()

    fun clear()
}