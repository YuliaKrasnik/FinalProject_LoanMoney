package com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import io.reactivex.Single

class GetListOfLoansFromDbUseCase (private val loanRepository: ILoanRepository) {
    operator fun invoke(): Single<List<Loan>> =
            loanRepository.getLoansListFromDb()
}