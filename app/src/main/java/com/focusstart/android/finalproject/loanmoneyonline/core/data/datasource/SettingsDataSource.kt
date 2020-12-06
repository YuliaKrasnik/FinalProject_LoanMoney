package com.focusstart.android.finalproject.loanmoneyonline.core.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.SettingsProviderImpl

interface ISettingsDataSource {
    fun setFlagFirstLaunchApp(flag: Boolean)
    fun getFlagFirstLaunchApp(): Boolean
}

class SettingsDataSourceImpl(private val settingsProvider: SettingsProviderImpl) : ISettingsDataSource {
    override fun setFlagFirstLaunchApp(flag: Boolean) = settingsProvider.setFlagFirstLaunchApp(flag)

    override fun getFlagFirstLaunchApp(): Boolean = settingsProvider.getFlagFirstLaunchApp()
}

