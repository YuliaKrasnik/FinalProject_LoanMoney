package com.focusstart.android.finalproject.loanmoneyonline.data.datasource

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.data.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.data.network.ILoanApi
import com.focusstart.android.finalproject.loanmoneyonline.data.network.RetrofitBuilder
import io.reactivex.Single
import retrofit2.Response

interface LoginDataSource {
    fun registrationInApp(name: String, password: String): Single<Response<UserEntity>>
}

class LoginDataSourceImpl : LoginDataSource {
    private val apiService by lazy { RetrofitBuilder.buildService(ILoanApi::class.java) }

    override fun registrationInApp(name: String, password: String): Single<Response<UserEntity>> {
        val auth = Auth(name, password)
        return apiService.registrationInApp(auth)
    }

}