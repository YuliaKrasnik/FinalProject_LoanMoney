package com.focusstart.android.finalproject.loanmoneyonline.di.application

import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.PresentersComponent
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.PresentersModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun newPresenterComponent(module: PresentersModule): PresentersComponent
}