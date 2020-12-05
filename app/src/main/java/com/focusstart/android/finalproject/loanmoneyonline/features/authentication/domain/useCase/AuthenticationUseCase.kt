package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.repository.ILoginRepository
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

class AuthenticationUseCase(private val loginRepository: ILoginRepository) {
    operator fun invoke(name: String, password: String): Single<Response<ResponseBody>> =
            loginRepository.authentication(name, password)
}