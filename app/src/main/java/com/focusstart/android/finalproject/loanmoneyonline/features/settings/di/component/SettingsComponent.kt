package com.focusstart.android.finalproject.loanmoneyonline.features.settings.di.component

import com.focusstart.android.finalproject.loanmoneyonline.features.settings.di.module.SettingsPresenterModule
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.di.scope.SettingsScope
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.ui.SettingsFragment
import dagger.Subcomponent

@SettingsScope
@Subcomponent(modules = [SettingsPresenterModule::class])
interface SettingsComponent {
    fun inject(fragment: SettingsFragment)
}