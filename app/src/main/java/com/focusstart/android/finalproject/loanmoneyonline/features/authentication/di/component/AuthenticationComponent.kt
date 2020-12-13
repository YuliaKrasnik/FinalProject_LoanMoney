package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.component

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module.*
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.scope.AuthenticationScope
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.ui.AuthenticationFragment
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.ui.RegistrationFragment
import dagger.Subcomponent

@AuthenticationScope
@Subcomponent(modules = [
    AuthenticationPresentersModule::class,
    AuthenticationUseCasesModule::class,
    AuthenticationRepositoriesModule::class,
    AuthenticationSourcesModule::class,
    AuthenticationApiModule::class])
interface AuthenticationComponent {
    fun inject(fragment: AuthenticationFragment)
    fun inject(fragment: RegistrationFragment)
}