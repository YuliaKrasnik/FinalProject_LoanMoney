package com.focusstart.android.finalproject.loanmoneyonline.domain.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import io.reactivex.Single
import retrofit2.Response

interface ILoanRepository {
    fun getLoansList():Single<Response<List<Loan>>>
}