package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.dataSource

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.network.api.IAuthApi
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface LoginDataSource {
    fun registrationInApp(name: String, password: String): Single<Response<UserEntity>>
    fun authentication(name: String, password: String): Single<Response<ResponseBody>>
}

class LoginDataSourceImpl(private val apiService: IAuthApi) : LoginDataSource {

    override fun registrationInApp(name: String, password: String): Single<Response<UserEntity>> {
        val auth = Auth(name, password)
        return apiService.registrationInApp(auth)
    }

    override fun authentication(name: String, password: String): Single<Response<ResponseBody>> {
        val auth = Auth(name, password)
        return apiService.authenticationIntoApp(auth)
    }

}