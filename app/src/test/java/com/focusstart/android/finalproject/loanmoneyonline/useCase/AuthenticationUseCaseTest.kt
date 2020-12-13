package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.repository.ILoginRepository
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.AuthenticationUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import okhttp3.ResponseBody
import org.junit.Test
import org.mockito.Mockito.verify
import retrofit2.Response

class AuthenticationUseCaseTest {
    private val loginRepository: ILoginRepository = mock()
    private val useCase = AuthenticationUseCase(loginRepository)
    private val name = "name"
    private val password = "password"
    private val auth = Auth(name, password)

    @Test
    fun `on invoke EXPECT authentication in login repository`() {
        useCase(auth)

        verify(loginRepository).authentication(auth)
    }

    @Test
    fun `on invoke EXPECT complete`() {
        val response: Response<ResponseBody> = Response.success(ResponseBody.create(null, ""))

        whenever(
                loginRepository.authentication(
                        auth
                )
        ).thenReturn(Single.just(response))
    }

    @Test
    fun `on invoke EXPECT get response`() {
        val response: Response<ResponseBody> = Response.success(ResponseBody.create(null, ""))
        whenever(
                loginRepository.authentication(
                        auth
                )
        ).thenReturn(Single.just(response))

        useCase(auth)
                .test()
                .assertValue(response)
    }

    @Test
    fun `on invoke EXPECT error`() {
        val response = Throwable("error")

        whenever(
                loginRepository.authentication(
                        auth
                )
        ).thenReturn(Single.error(response))

        useCase(auth)
                .test()
                .assertError(response)
    }
}
