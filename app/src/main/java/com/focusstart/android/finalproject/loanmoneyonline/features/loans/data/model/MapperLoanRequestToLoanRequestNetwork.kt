package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model

import com.focusstart.android.finalproject.loanmoneyonline.core.data.converter.Mapper
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanRequest

class MapperLoanRequestToLoanRequestNetwork : Mapper<LoanRequest, LoanRequestNetwork> {
    override fun map(input: LoanRequest): LoanRequestNetwork {
        return LoanRequestNetwork(
            input.amount,
            input.firstName,
            input.lastName,
            input.percent,
            input.period,
            input.phoneNumber
        )
    }
}