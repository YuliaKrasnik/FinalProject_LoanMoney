package com.focusstart.android.finalproject.loanmoneyonline.di.presenters

import android.content.SharedPreferences
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSourceImpl
import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.SettingsSourceImpl
import dagger.Module
import dagger.Provides

@Module
class SourcesModule {
    @Provides
    @PresentersScope
    fun provideLoginSource(): LoginDataSourceImpl =
        LoginDataSourceImpl()

    @Provides
    @PresentersScope
    fun provideLoanSource(): LoanDataSourceImpl =
        LoanDataSourceImpl()

    @Provides
    @PresentersScope
    fun provideSettingsSource(preferences: SharedPreferences): SettingsSourceImpl =
        SettingsSourceImpl(preferences)

}