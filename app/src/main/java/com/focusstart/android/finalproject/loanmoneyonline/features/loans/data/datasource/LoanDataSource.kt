package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db.LoansDao
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanConditionsNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanRequestNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.network.api.ILoanApi
import io.reactivex.Single
import retrofit2.Response

interface LoanDataSource {
    fun getLoansList(): Single<Response<List<LoanNetwork>>>
    fun registerLoan(loanRequestNetwork: LoanRequestNetwork): Single<Response<LoanNetwork>>
    fun getLoanConditions(): Single<Response<LoanConditionsNetwork>>
}

class LoanDataSourceImpl(private val apiService: ILoanApi, dao: LoansDao) : LoanDataSource {
    override fun getLoansList(): Single<Response<List<LoanNetwork>>> {
        return apiService.getLoansList()
    }

    override fun registerLoan(loanRequestNetwork: LoanRequestNetwork): Single<Response<LoanNetwork>> {
        return apiService.createNewLoan(loanRequestNetwork)
    }

    override fun getLoanConditions(): Single<Response<LoanConditionsNetwork>> {
        return apiService.getLoanConditions()
    }

}