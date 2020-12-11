package com.focusstart.android.finalproject.loanmoneyonline.core.di.main.component

import com.focusstart.android.finalproject.loanmoneyonline.core.di.main.module.MainPresenterModule
import com.focusstart.android.finalproject.loanmoneyonline.core.di.main.scope.MainScope
import com.focusstart.android.finalproject.loanmoneyonline.core.ui.MainActivity
import dagger.Subcomponent

@MainScope
@Subcomponent(modules = [MainPresenterModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}