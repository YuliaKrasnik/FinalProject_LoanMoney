package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.db.LoansDao
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db.LoanDb
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanConditionsNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanRequestNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.network.api.ILoanApi
import io.reactivex.Single
import retrofit2.Response

interface LoanDataSource {
    fun getLoansListFromNetwork(): Single<Response<List<LoanNetwork>>>
    fun registerLoan(loanRequestNetwork: LoanRequestNetwork): Single<Response<LoanNetwork>>
    fun getLoanConditions(): Single<Response<LoanConditionsNetwork>>
    fun getLoansListFromDb(): Single<List<LoanDb>>
    fun saveLoansListInDb(listOfLoansDb: List<LoanDb>)
    fun saveLoanInDd(loan: LoanDb)
    fun deleteCachedLoans()
}

class LoanDataSourceImpl(private val apiService: ILoanApi, private val dao: LoansDao) : LoanDataSource {
    override fun getLoansListFromNetwork(): Single<Response<List<LoanNetwork>>> {
        return apiService.getLoansList()
    }

    override fun registerLoan(loanRequestNetwork: LoanRequestNetwork): Single<Response<LoanNetwork>> {
        return apiService.createNewLoan(loanRequestNetwork)
    }

    override fun getLoanConditions(): Single<Response<LoanConditionsNetwork>> {
        return apiService.getLoanConditions()
    }

    override fun getLoansListFromDb(): Single<List<LoanDb>> {
        return dao.getListOfLoans()
    }

    override fun saveLoansListInDb(listOfLoansDb: List<LoanDb>) {
        dao.insertListLoans(listOfLoansDb)
    }

    override fun saveLoanInDd(loan: LoanDb) {
        dao.insertOneLoan(loan)
    }

    override fun deleteCachedLoans() {
        dao.deleteAll()
    }

}