package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db

import androidx.room.*
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db.LoanDb
import io.reactivex.Single

@Dao
interface LoansDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListLoans(loans: List<LoanDb>)

    @Insert
    fun insertOneLoan(loan: LoanDb)

    @Query("SELECT * FROM loan ORDER BY id DESC")
    fun getListOfLoans(): Single<List<LoanDb>>

    @Query("DELETE FROM loan")
    fun deleteAll()
}