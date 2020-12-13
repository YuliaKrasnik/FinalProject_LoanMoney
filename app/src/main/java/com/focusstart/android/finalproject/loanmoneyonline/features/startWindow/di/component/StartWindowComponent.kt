package com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.di.component

import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.di.module.StartWindowPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.di.scope.StartWindowScope
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.ui.StartFragment
import dagger.Subcomponent

@StartWindowScope
@Subcomponent(modules = [StartWindowPresentersModule::class])
interface StartWindowComponent {
    fun inject(fragment: StartFragment)
}