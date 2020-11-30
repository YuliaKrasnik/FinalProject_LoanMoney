package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.repository

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.UserEntity
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface ILoginRepository {
    fun registrationInApp(name: String, password: String): Single<Response<UserEntity>>
    fun authentication(name: String, password: String): Single<Response<ResponseBody>>
}
