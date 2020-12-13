package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.repository.ILoginRepository
import io.reactivex.Single
import retrofit2.Response

class RegistrationInAppUseCase(private val loginRepository: ILoginRepository) {
    operator fun invoke(auth: Auth): Single<Response<UserEntity>> =
            loginRepository.registrationInApp(auth)
}