package com.focusstart.android.finalproject.loanmoneyonline.domain

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class GetListOfLoansUseCase(private val loanRepository: ILoanRepository) {
    operator fun invoke(): Single<Response<List<Loan>>> =
        loanRepository.getLoansList()
}