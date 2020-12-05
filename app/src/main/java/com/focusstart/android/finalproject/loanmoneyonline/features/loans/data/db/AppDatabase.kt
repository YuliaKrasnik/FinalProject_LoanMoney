package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db

import androidx.room.Database
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db.LoanDb

@Database(entities = [LoanDb::class], version = 1)
abstract class AppDatabase {
    abstract fun loansDao(): LoansDao
}