package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.component

import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module.SplashScreenPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module.SplashScreenUseCasesModule
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.scope.SplashScreenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.ui.SplashScreenFragment
import dagger.Subcomponent

@SplashScreenScope
@Subcomponent(modules = [
    SplashScreenPresentersModule::class,
    SplashScreenUseCasesModule::class])
interface SplashScreenComponent {
    fun inject(fragment: SplashScreenFragment)
}