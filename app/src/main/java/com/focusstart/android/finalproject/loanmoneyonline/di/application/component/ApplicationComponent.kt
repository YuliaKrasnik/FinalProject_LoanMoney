package com.focusstart.android.finalproject.loanmoneyonline.di.application.component

import com.focusstart.android.finalproject.loanmoneyonline.di.application.module.ApplicationModule
import com.focusstart.android.finalproject.loanmoneyonline.di.application.module.NetworkModule
import com.focusstart.android.finalproject.loanmoneyonline.di.application.scope.ApplicationScope
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.component.PresentersComponent
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.module.PresentersModule
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun newPresenterComponent(module: PresentersModule): PresentersComponent
}