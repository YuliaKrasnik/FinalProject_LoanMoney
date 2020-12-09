package com.focusstart.android.finalproject.loanmoneyonline.core.di.component

import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.core.di.module.*
import com.focusstart.android.finalproject.loanmoneyonline.core.di.scope.ApplicationScope
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.component.AuthenticationComponent
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module.AuthenticationPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.di.component.ExplanationsComponent
import com.focusstart.android.finalproject.loanmoneyonline.features.explanations.di.module.ExplanationPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.component.LoansComponent
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.di.module.LoanPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.component.SplashScreenComponent
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module.SplashScreenPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.di.component.StartWindowComponent
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.di.module.StartWindowPresentersModule
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class, NetworkModule::class, DatabaseModule::class, SettingsModule::class, WorkerModule::class])
interface ApplicationComponent {
    fun newAuthenticationComponent(module: AuthenticationPresentersModule): AuthenticationComponent
    fun newExplanationsComponent(module: ExplanationPresentersModule): ExplanationsComponent
    fun newLoansComponent(module: LoanPresentersModule): LoansComponent
    fun newSplashScreenComponent(module: SplashScreenPresentersModule): SplashScreenComponent
    fun newStartWindowComponent(module: StartWindowPresentersModule): StartWindowComponent
    fun inject(application: App)
}