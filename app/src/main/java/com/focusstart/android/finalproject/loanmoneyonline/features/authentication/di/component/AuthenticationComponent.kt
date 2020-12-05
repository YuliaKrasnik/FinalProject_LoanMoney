package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.component

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module.*
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.ui.AuthenticationFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.ui.RegistrationFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.module.TokenRepositoriesModule
import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.module.TokenSourcesModule
import com.focusstart.android.finalproject.loanmoneyonline.features.token.di.scope.TokenScope
import dagger.Subcomponent

@TokenScope
@Subcomponent(modules = [
    AuthenticationPresentersModule::class,
    AuthenticationUseCasesModule::class,
    AuthenticationRepositoriesModule::class,
    AuthenticationSourcesModule::class,
    AuthenticationApiModule::class,
    TokenRepositoriesModule::class,
    TokenSourcesModule::class])
interface AuthenticationComponent {
    fun inject(fragment: AuthenticationFragment)
    fun inject(fragment: RegistrationFragment)
}