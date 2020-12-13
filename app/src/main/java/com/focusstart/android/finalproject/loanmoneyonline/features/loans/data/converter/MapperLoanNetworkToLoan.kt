package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.converter

import com.focusstart.android.finalproject.loanmoneyonline.core.data.converter.Mapper
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan

class MapperLoanNetworkToLoan : Mapper<LoanNetwork?, Loan> {
    override fun map(input: LoanNetwork?): Loan {
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