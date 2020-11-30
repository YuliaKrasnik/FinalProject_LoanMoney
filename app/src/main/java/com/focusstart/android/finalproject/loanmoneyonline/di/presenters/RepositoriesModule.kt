package com.focusstart.android.finalproject.loanmoneyonline.di.presenters

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SettingsSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoanRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.LoginRepositoryImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.repository.SettingsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [SourcesModule::class])
class RepositoriesModule {
    @Provides
    @PresentersScope
    fun provideLoginRepository(loginDataSource: LoginDataSourceImpl): LoginRepositoryImpl =
        LoginRepositoryImpl(loginDataSource)

    @Provides
    @PresentersScope
    fun provideLoanRepository(
        loanDataSourceImpl: LoanDataSourceImpl,
        settingsSourceImpl: SettingsSourceImpl
    ): LoanRepositoryImpl =
        LoanRepositoryImpl(loanDataSourceImpl, settingsSourceImpl)

    @Provides
    @PresentersScope
    fun provideSettingsRepository(settingsSourceImpl: SettingsSourceImpl): SettingsRepositoryImpl =
        SettingsRepositoryImpl(settingsSourceImpl)

}