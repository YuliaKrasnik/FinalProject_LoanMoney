package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.converter

import com.focusstart.android.finalproject.loanmoneyonline.core.data.converter.Mapper
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanConditionsNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanConditions

class MapperLoanConditionsNetworkToLoanConditions : Mapper<LoanConditionsNetwork?, LoanConditions> {
    override fun map(input: LoanConditionsNetwork?): LoanConditions {
        return LoanConditions(
            input?.maxAmount ?: 0,
            input?.percent ?: 0.0,
            input?.period ?: 0
        )
    }
}