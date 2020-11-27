package com.focusstart.android.finalproject.loanmoneyonline.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanRequest
import com.focusstart.android.finalproject.loanmoneyonline.data.network.ILoanApi
import com.focusstart.android.finalproject.loanmoneyonline.data.network.RetrofitBuilder
import io.reactivex.Single
import retrofit2.Response

interface LoanDataSource {
    fun getLoansList(): Single<Response<List<Loan>>>
    fun registerLoan(loanRequest: LoanRequest): Single<Response<Loan>>
}
class LoanDataSourceImpl : LoanDataSource {
    private val apiService by lazy { RetrofitBuilder.buildService(ILoanApi::class.java) }
  //  private val token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ5biIsImV4cCI6MTYwOTA1NjIwN30.t1xr1AbUFVnQgEU8CFlofh-i2IKqGYq6cyYVTOAMyfpJpgAPc7QweL6rHFkBlSZeraFotQqqhPtiznKKp2fWMA" //
    private val token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHJpbmciLCJleHAiOjE2MDkwNjkxNjN9.tWn3YAlka6hHiG2mz7x6G70u-h9USLfcR1qnLCANSvwKk3ri8v-n1qCCMuaJXHoyra2w4UPXLwVfYpsLicctmg" //

    override fun getLoansList(): Single<Response<List<Loan>>> {
        return apiService.getLoansList(token)    //TODO достать значение из sharedPref в data слое
    }

    override fun registerLoan(loanRequest: LoanRequest): Single<Response<Loan>> {
        return apiService.createNewLoan(loanRequest, token)
    }

}