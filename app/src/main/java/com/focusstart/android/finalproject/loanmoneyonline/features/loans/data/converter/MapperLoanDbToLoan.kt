package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.converter

import com.focusstart.android.finalproject.loanmoneyonline.core.data.converter.Mapper
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db.LoanDb
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan

class MapperLoanDbToLoan : Mapper<LoanDb?, Loan> {
    override fun map(input: LoanDb?): Loan {
        return Loan(
                input?.amount ?: 0,
                input?.date.orEmpty(),
                input?.firstName.orEmpty(),
                input?.id ?: 0,
                input?.lastName.orEmpty(),
                input?.percent ?: 0.0,
                input?.period ?: 0,
                input?.phoneNumber.orEmpty(),
                input?.state.orEmpty()
        )
    }
}