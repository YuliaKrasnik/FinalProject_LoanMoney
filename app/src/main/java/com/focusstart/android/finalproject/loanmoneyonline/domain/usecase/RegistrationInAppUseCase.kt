package com.focusstart.android.finalproject.loanmoneyonline.domain.usecase

import com.focusstart.android.finalproject.loanmoneyonline.data.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ILoginRepository
import io.reactivex.Single
import retrofit2.Response

class RegistrationInAppUseCase(private val loginRepository: ILoginRepository) {
    operator fun invoke(name: String, password: String): Single<Response<UserEntity>> =
        loginRepository.registrationInApp(name, password)
}