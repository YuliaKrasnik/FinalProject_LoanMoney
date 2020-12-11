package com.focusstart.android.finalproject.loanmoneyonline.core.data.provider

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.APP_PREFERENCES_FIRST_LAUNCH
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.APP_PREFERENCES_LANGUAGE
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe

interface ISettingsProvider {
    fun setFlagFirstLaunchApp(flag: Boolean)
    fun getFlagFirstLaunchApp(): Boolean
    fun setLanguage(locale: String)
    fun getLanguage(): String?
    fun listeningLanguageUpdate(): Flowable<String>
}

class SettingsProviderImpl(private val preferences: SharedPreferences) : ISettingsProvider {
    private var listener: SharedPreferences.OnSharedPreferenceChangeListener? = null

    override fun setFlagFirstLaunchApp(flag: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(APP_PREFERENCES_FIRST_LAUNCH, flag)
        editor.apply()
    }

    override fun getFlagFirstLaunchApp(): Boolean {
        var flag = false
        if (preferences.contains(APP_PREFERENCES_FIRST_LAUNCH)) {
            flag = preferences.getBoolean(APP_PREFERENCES_FIRST_LAUNCH, false)
        }
        return flag
    }

    override fun setLanguage(locale: String) {
        val editor = preferences.edit()
        editor.putString(APP_PREFERENCES_LANGUAGE, locale)
        editor.apply()
    }

    override fun getLanguage(): String? {
        var language: String? = null
        if (preferences.contains(APP_PREFERENCES_LANGUAGE)) {
            language = preferences.getString(APP_PREFERENCES_LANGUAGE, null)
        }
        return language
    }

    override fun listeningLanguageUpdate() =
            Flowable.create(FlowableOnSubscribe<String> { emitter ->
                listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
                    if (key == APP_PREFERENCES_LANGUAGE) {
                        val language = getLanguage()
                        language?.let { emitter.onNext(language) }
                    }
                }
                preferences.registerOnSharedPreferenceChangeListener(listener)

            }, BackpressureStrategy.LATEST)

}

