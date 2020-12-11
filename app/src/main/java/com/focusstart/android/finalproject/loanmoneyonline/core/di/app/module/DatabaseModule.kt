package com.focusstart.android.finalproject.loanmoneyonline.core.di.app.module

import android.app.Application
import androidx.room.Room
import com.focusstart.android.finalproject.loanmoneyonline.core.di.app.scope.ApplicationScope
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    @ApplicationScope
    fun provideRoomDb(context: Application) =
        Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
}