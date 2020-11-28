package com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen

interface ISplashScreenPresenter {
    fun onResume()

    fun attachView(view: ISplashScreenView)

    fun detachView()

    fun clear()
}