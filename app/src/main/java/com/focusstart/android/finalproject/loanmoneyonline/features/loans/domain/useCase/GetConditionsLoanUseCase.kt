package com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class GetConditionsLoanUseCase(private val loanRepository: ILoanRepository) {
    operator fun invoke(): Single<Response<LoanConditions>> =
            loanRepository.getLoanConditions()
}