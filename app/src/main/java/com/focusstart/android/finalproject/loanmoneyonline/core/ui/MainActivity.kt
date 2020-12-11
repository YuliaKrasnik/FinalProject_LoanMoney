package com.focusstart.android.finalproject.loanmoneyonline.core.ui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.ISettingsProvider
import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.SettingsProviderImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.di.main.module.MainPresenterModule
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IMainPresenter
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IMainView
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {
    @Inject
    lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
    }

    private fun initPresenter() {
        (application as App)
                .getApplicationComponent()
                .newMainComponent(MainPresenterModule())
                .inject(this)
        presenter.attachView(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(createContextWithChangedLanguage(base))
    }

    private fun createContextWithChangedLanguage(base: Context): Context {
        val settingsProvider: ISettingsProvider = SettingsProviderImpl((base.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE)))
        val localeString = settingsProvider.getLanguage()
        var locale: Locale = Locale.getDefault()
        if (localeString != null) locale = Locale(localeString)

        val newConfiguration = Configuration(base.resources.configuration)
        Locale.setDefault(locale)
        newConfiguration.setLocale(locale)
        return base.createConfigurationContext(newConfiguration)
    }

    override fun restartView() {
        recreate()
    }

    override fun onDestroy() {
        presenter.detachView()
        presenter.clear()
        super.onDestroy()
    }

}