package com.focusstart.android.finalproject.loanmoneyonline

import android.app.Application
import com.focusstart.android.finalproject.loanmoneyonline.Constants.BASE_URL
import com.focusstart.android.finalproject.loanmoneyonline.di.application.ApplicationComponent
import com.focusstart.android.finalproject.loanmoneyonline.di.application.ApplicationModule
import com.focusstart.android.finalproject.loanmoneyonline.di.application.DaggerApplicationComponent
import com.focusstart.android.finalproject.loanmoneyonline.di.application.NetworkModule


class App : Application() {
    private var applicationComponent: ApplicationComponent? = null

    fun getApplicationComponent(): ApplicationComponent {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(this))
                    .networkModule(NetworkModule(BASE_URL))
                    .build()
        }
        return applicationComponent!!
    }
}