package com.focusstart.android.finalproject.loanmoneyonline.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.datasource.LoginDataSource
import com.focusstart.android.finalproject.loanmoneyonline.data.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ILoginRepository
import io.reactivex.Single
import retrofit2.Response

class LoginRepositoryImpl(private val dataSource: LoginDataSource) : ILoginRepository {

    override fun registrationInApp(name: String, password: String): Single<Response<UserEntity>> =
        dataSource.registrationInApp(name, password)
}