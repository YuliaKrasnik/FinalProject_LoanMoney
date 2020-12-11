package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.converter.*
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.datasource.LoanDataSource
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db.LoanDb
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanConditionsNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network.LoanNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.repository.ILoanRepository
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

class LoanRepositoryImpl(
        private val dataSource: LoanDataSource
) : ILoanRepository {
    override fun getLoansListFromNetwork(): Single<Response<List<Loan>>> =
            dataSource.getLoansListFromNetwork()
                    .map {
                        when (it.isSuccessful) {
                            true -> Response.success(mapperListOfLoansNetworkToListOfLoans(it.body()))
                            false -> Response.error(it.code(), it.errorBody() as ResponseBody)
                        }
                    }

    private fun mapperListOfLoansNetworkToListOfLoans(listOfLoansNetwork: List<LoanNetwork>?): List<Loan>? =
            listOfLoansNetwork?.map {
                MapperLoanNetworkToLoan().map(it)
            }

    override fun registerLoan(loanRequest: LoanRequest): Single<Response<Loan>> {
        return dataSource.registerLoan(mapperLoanRequestToLoanRequestNetwork(loanRequest))
                .map {
                    when (it.isSuccessful) {
                        true -> Response.success(mapperLoanNetworkToLoan(it.body()))
                        false -> Response.error(it.code(), it.errorBody() as ResponseBody)
                    }
                }
    }

    private fun mapperLoanNetworkToLoan(loanNetwork: LoanNetwork?): Loan? =
            MapperLoanNetworkToLoan().map(loanNetwork)

    private fun mapperLoanRequestToLoanRequestNetwork(loanRequest: LoanRequest) =
            MapperLoanRequestToLoanRequestNetwork().map(loanRequest)

    override fun getLoanConditions(): Single<Response<LoanConditions>> =
            dataSource.getLoanConditions()
                    .map {
                        when (it.isSuccessful) {
                            true -> Response.success(mapperLoanConditionsNetworkToLoanConditions(it.body()))
                            false -> Response.error(it.code(), it.errorBody() as ResponseBody)
                        }
                    }

    override fun getLoansListFromDb(): Single<List<Loan>> =
            dataSource.getLoansListFromDb()
                    .map {
                        mapperListOfLoansDbToListOfLoans(it)
                    }

    override fun saveLoansListInDb(listOfLoans: List<Loan>) =
            dataSource.saveLoansListInDb(mapperListOfLoansToListOfLoansDb(listOfLoans))

    override fun saveLoanInDb(loan: Loan) {
        dataSource.saveLoanInDd(mapperLoanToLoanDb(loan))
    }

    override fun deleteCachedLoans() = dataSource.deleteCachedLoans()

    private fun mapperLoanToLoanDb(loan: Loan): LoanDb =
            MapperLoanToLoanDb().map(loan)

    private fun mapperListOfLoansToListOfLoansDb(listOfLoans: List<Loan>): List<LoanDb> =
            listOfLoans.map {
                MapperLoanToLoanDb().map(it)
            }

    private fun mapperListOfLoansDbToListOfLoans(listOfLoansDb: List<LoanDb>?): List<Loan>? =
            listOfLoansDb?.map {
                MapperLoanDbToLoan().map(it)
            }

    private fun mapperLoanConditionsNetworkToLoanConditions(loanConditionsNetwork: LoanConditionsNetwork?): LoanConditions? =
            MapperLoanConditionsNetworkToLoanConditions().map(loanConditionsNetwork)
}