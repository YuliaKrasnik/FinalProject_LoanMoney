package com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository

import io.reactivex.Flowable

interface ISettingsRepository {
    fun setFlagFirstLaunchApp(flag: Boolean)
    fun getFlagFirstLaunchApp(): Boolean
    fun setLanguage(locale: String)
    fun getLanguage(): String?
    fun listeningLanguageUpdate(): Flowable<String>
}