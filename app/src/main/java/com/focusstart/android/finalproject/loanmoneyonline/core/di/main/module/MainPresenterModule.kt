package com.focusstart.android.finalproject.loanmoneyonline.core.di.main.module

import com.focusstart.android.finalproject.loanmoneyonline.core.di.main.scope.MainScope
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.ListeningLanguageUseCase
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.IMainPresenter
import com.focusstart.android.finalproject.loanmoneyonline.core.presentation.MainPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [MainUseCasesModule::class])
class MainPresenterModule {
    @MainScope
    @Provides
    fun provideMainActivityPresenter(listeningLanguageUseCase : ListeningLanguageUseCase): IMainPresenter = MainPresenterImpl(listeningLanguageUseCase )
}