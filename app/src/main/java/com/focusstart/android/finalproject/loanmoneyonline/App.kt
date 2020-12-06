package com.focusstart.android.finalproject.loanmoneyonline

import android.app.Application
import com.focusstart.android.finalproject.loanmoneyonline.core.di.component.ApplicationComponent
import com.focusstart.android.finalproject.loanmoneyonline.core.di.component.DaggerApplicationComponent
import com.focusstart.android.finalproject.loanmoneyonline.core.di.module.ApplicationModule
import com.focusstart.android.finalproject.loanmoneyonline.core.di.module.DatabaseModule
import com.focusstart.android.finalproject.loanmoneyonline.core.di.module.NetworkModule
import com.focusstart.android.finalproject.loanmoneyonline.core.di.module.SettingsModule
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BASE_URL


class App : Application() {
    private var applicationComponent: ApplicationComponent? = null

    fun getApplicationComponent(): ApplicationComponent {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(this))
                    .networkModule(NetworkModule(BASE_URL))
                    .databaseModule(DatabaseModule())
                    .settingsModule(SettingsModule())
                    .build()
        }
        return applicationComponent!!
    }
}