package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.dataSource

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.AuthNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.UserEntityNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.network.api.IAuthApi
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface LoginDataSource {
    fun registrationInApp(authNetwork: AuthNetwork): Single<Response<UserEntityNetwork>>
    fun authentication(authNetwork: AuthNetwork): Single<Response<ResponseBody>>
}

class LoginDataSourceImpl(private val apiService: IAuthApi) : LoginDataSource {

    override fun registrationInApp(authNetwork: AuthNetwork): Single<Response<UserEntityNetwork>> {
        return apiService.registrationInApp(authNetwork)
    }

    override fun authentication(authNetwork: AuthNetwork): Single<Response<ResponseBody>> {
        return apiService.authenticationIntoApp(authNetwork)
    }

}