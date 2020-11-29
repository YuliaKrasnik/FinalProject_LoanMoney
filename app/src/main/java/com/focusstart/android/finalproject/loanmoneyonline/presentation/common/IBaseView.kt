package com.focusstart.android.finalproject.loanmoneyonline.presentation.common

import android.app.Application
import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.PresentersComponent
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.PresentersModule

interface IBaseView {
    fun getPresentersComponent(app: Application): PresentersComponent {
        return (app as App).getApplicationComponent().newPresenterComponent(
            PresentersModule()
        )
    }
}