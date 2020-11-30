package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.domain.usecase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class GetListOfLoansUseCase(private val loanRepository: ILoanRepository) {
    operator fun invoke(): Single<Response<List<Loan>>> =
            loanRepository.getLoansList()
}