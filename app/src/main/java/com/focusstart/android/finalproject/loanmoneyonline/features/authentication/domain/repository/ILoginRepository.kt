package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.repository

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.UserEntity
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface ILoginRepository {
    fun registrationInApp(auth: Auth): Single<Response<UserEntity>>
    fun authentication(auth: Auth): Single<Response<ResponseBody>>
}
