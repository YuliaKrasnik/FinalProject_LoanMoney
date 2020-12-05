package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db.LoanDb

@Database(entities = [LoanDb::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun loansDao(): LoansDao
}