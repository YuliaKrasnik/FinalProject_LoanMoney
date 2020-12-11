package com.focusstart.android.finalproject.loanmoneyonline.core.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.core.data.provider.ISettingsProvider
import io.reactivex.Flowable

interface ISettingsDataSource {
    fun setFlagFirstLaunchApp(flag: Boolean)
    fun getFlagFirstLaunchApp(): Boolean
    fun setLanguage(locale: String)
    fun getLanguage(): String?
    fun listeningLanguageUpdate(): Flowable<String>
}

class SettingsDataSourceImpl(private val settingsProvider: ISettingsProvider) : ISettingsDataSource {
    override fun setFlagFirstLaunchApp(flag: Boolean) = settingsProvider.setFlagFirstLaunchApp(flag)

    override fun getFlagFirstLaunchApp(): Boolean = settingsProvider.getFlagFirstLaunchApp()

    override fun setLanguage(locale: String) = settingsProvider.setLanguage(locale)

    override fun getLanguage(): String? = settingsProvider.getLanguage()

    override fun listeningLanguageUpdate(): Flowable<String> = settingsProvider.listeningLanguageUpdate()

}

