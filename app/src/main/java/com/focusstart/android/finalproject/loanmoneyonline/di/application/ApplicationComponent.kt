package com.focusstart.android.finalproject.loanmoneyonline.di.application

import com.focusstart.android.finalproject.loanmoneyonline.data.network.api.IAuthApi
import com.focusstart.android.finalproject.loanmoneyonline.data.network.api.ILoanApi
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.PresentersComponent
import com.focusstart.android.finalproject.loanmoneyonline.di.presenters.PresentersModule
import dagger.Component
import dagger.Provides
import retrofit2.Retrofit

@ApplicationScope
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun newPresenterComponent(module: PresentersModule): PresentersComponent
}