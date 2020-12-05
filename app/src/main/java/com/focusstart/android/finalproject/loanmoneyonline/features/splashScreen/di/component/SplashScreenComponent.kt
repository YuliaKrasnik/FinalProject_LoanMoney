package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.component

import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module.SplashScreenPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module.SplashScreenUseCasesModule
import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.module.TokenRepositoriesModule
import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.module.TokenSourcesModule
import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.ui.SplashScreenFragment
import dagger.Subcomponent

@TokenScope
@Subcomponent(modules = [
    SplashScreenPresentersModule::class,
    SplashScreenUseCasesModule::class,
    TokenRepositoriesModule::class,
    TokenSourcesModule::class])
interface SplashScreenComponent {
    fun inject(fragment: SplashScreenFragment)
}