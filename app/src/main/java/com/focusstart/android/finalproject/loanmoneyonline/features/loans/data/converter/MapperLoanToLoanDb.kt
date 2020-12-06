package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.converter

import com.focusstart.android.finalproject.loanmoneyonline.core.data.converter.Mapper
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db.LoanDb
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan

class MapperLoanToLoanDb : Mapper<Loan, LoanDb> {
    override fun map(input: Loan): LoanDb {
        return LoanDb(
                input.id,
                input.amount,
                input.date,
                input.firstName,
                input.lastName,
                input.percent,
                input.period,
                input.phoneNumber,
                input.state
        )
    }
}