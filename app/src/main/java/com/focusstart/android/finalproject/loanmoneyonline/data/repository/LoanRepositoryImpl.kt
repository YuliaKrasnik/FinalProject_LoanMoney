package com.focusstart.android.finalproject.loanmoneyonline.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoanDataSource
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class LoanRepositoryImpl(private val dataSource: LoanDataSource) : ILoanRepository {
    override fun getLoansList(): Single<Response<List<Loan>>>  =
        dataSource.getLoansList()



}