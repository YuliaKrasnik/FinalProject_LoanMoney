package com.focusstart.android.finalproject.loanmoneyonline.core.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.core.data.datasource.SettingsDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository
import io.reactivex.Flowable

class SettingsRepositoryImpl(private val settingsDataSource: SettingsDataSourceImpl) :
    ISettingsRepository {
    override fun setFlagFirstLaunchApp(flag: Boolean) =
        settingsDataSource.setFlagFirstLaunchApp(flag)

    override fun getFlagFirstLaunchApp(): Boolean = settingsDataSource.getFlagFirstLaunchApp()

    override fun setLanguage(locale: String) = settingsDataSource.setLanguage(locale)

    override fun getLanguage(): String? = settingsDataSource.getLanguage()

    override fun listeningLanguageUpdate(): Flowable<String> = settingsDataSource.listeningLanguageUpdate()
}