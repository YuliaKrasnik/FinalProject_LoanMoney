package com.focusstart.android.finalproject.loanmoneyonline

import android.app.Application
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BASE_URL
import com.focusstart.android.finalproject.loanmoneyonline.di.application.component.ApplicationComponent
import com.focusstart.android.finalproject.loanmoneyonline.di.application.module.ApplicationModule
import com.focusstart.android.finalproject.loanmoneyonline.di.application.component.DaggerApplicationComponent
import com.focusstart.android.finalproject.loanmoneyonline.di.application.module.NetworkModule


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