package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.repository.ILoginRepository
import io.reactivex.Single
import retrofit2.Response

class RegistrationInAppUseCase(private val loginRepository: ILoginRepository) {
    operator fun invoke(name: String, password: String): Single<Response<UserEntity>> =
            loginRepository.registrationInApp(name, password)
}