package com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository

interface ISettingsRepository {
    fun setFlagFirstLaunchApp(flag: Boolean)
    fun getFlagFirstLaunchApp(): Boolean
}