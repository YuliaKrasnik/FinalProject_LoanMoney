package com.focusstart.android.finalproject.loanmoneyonline.domain

import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ILoanRepository
import io.reactivex.Single
import retrofit2.Response

class GetConditionsLoanUseCase(private val loanRepository: ILoanRepository) {
    operator fun invoke(): Single<Response<LoanConditions>> =
            loanRepository.getLoanConditions()
}