package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.repository.ILoginRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.RegistrationInAppUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test
import retrofit2.Response

class RegistrationInAppUseCaseTest {
    private val loginRepository: ILoginRepository = mock()
    private val useCase = RegistrationInAppUseCase(loginRepository)
    private val name = "name"
    private val password = "password"
    private val auth = Auth(name, password)
    private val userEntity = UserEntity("name", "role")
    private val response: Response<UserEntity> = Response.success(userEntity)

    @Test
    fun `on invoke EXPECT registration in app in login repository`() {
        useCase.invoke(auth)

        verify(loginRepository).registrationInApp(auth)
    }

    @Test
    fun `on invoke EXPECT complete`() {
        whenever(loginRepository.registrationInApp(auth)).thenReturn(Single.just(response))

        useCase(auth)
                .test()
                .assertComplete()
    }

    @Test
    fun `on invoke EXPECT get response user entity`() {
        whenever(
                loginRepository.registrationInApp(auth)
        ).thenReturn(Single.just(response))

        useCase(auth)
                .test()
                .assertValue(response)
    }

    @Test
    fun `on invoke EXPECT error`() {
        val response = Throwable("error")

        whenever(
                loginRepository.registrationInApp(auth)
        ).thenReturn(Single.error(response))

        useCase(auth)
                .test()
                .assertError(response)
    }


}