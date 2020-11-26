package com.focusstart.android.finalproject.loanmoneyonline.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.network.ILoanApi
import com.focusstart.android.finalproject.loanmoneyonline.data.network.RetrofitBuilder
import io.reactivex.Single
import retrofit2.Response

interface LoanDataSource {
    fun getLoansList(): Single<Response<List<Loan>>>
}
class LoanDataSourceImpl : LoanDataSource {
    private val apiService by lazy { RetrofitBuilder.buildService(ILoanApi::class.java) }
    private val token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHJpbmciLCJleHAiOjE2MDkwMTQzNjF9.FWcgctPyy5z5C2WDamUS93-F56rCFI8ShkmNzE91CYpqBp6RF7RSEEsmk2TCHVW28tNMfOq0beMr_PDV3ehsyQ" //

    override fun getLoansList(): Single<Response<List<Loan>>> {
        return apiService.getLoansList(token)    //TODO достать значение из sharedPref в data слое
    }


}