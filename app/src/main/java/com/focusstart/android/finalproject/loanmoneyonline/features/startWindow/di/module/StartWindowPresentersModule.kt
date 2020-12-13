package com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.di.module

import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.di.scope.StartWindowScope
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation.IStartWindowPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation.StartWindowPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class StartWindowPresentersModule {
    @Provides
    @StartWindowScope
    fun provideStartWindowPresenter(): IStartWindowPresenter = StartWindowPresenterImpl()
}