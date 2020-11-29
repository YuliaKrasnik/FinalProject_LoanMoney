package com.focusstart.android.finalproject.loanmoneyonline.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.ISettingsSource
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ISettingsRepository

class SettingsRepositoryImpl(private val settingsSource: ISettingsSource) : ISettingsRepository {

    override fun saveBearerToken(token: String) {
        settingsSource.saveBearerToken(token)
    }

    override fun checkingBearerTokenAvailability(): Boolean {
        return settingsSource.isTokenExists()
    }
}