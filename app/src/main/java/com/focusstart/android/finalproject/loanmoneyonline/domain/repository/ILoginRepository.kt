package com.focusstart.android.finalproject.loanmoneyonline.domain.repository

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.data.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.domain.entity.Result
import io.reactivex.Single
import retrofit2.Response

interface ILoginRepository{
    fun registrationInApp(name: String, password:String): Single<Response<UserEntity>>
}
