package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db.LoanDb
import io.reactivex.Single

@Dao
interface LoansDao {
    @Insert
    fun insertListLoans(loans: List<LoanDb>)

    @Insert
    fun insertOneLoan(loan: List<LoanDb>)

    @Query("SELECT * FROM loan")
    fun getListOfLoans(): Single<List<LoanDb>>

    @Delete
    fun deleteAll()
}