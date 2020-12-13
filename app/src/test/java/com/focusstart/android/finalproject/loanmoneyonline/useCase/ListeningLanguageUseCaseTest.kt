package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.ListeningLanguageUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Flowable
import org.junit.Test

class ListeningLanguageUseCaseTest {
    private val settingsRepository: ISettingsRepository = mock()
    private val useCase = ListeningLanguageUseCase(settingsRepository)
    private val locale = "ru"

    @Test
    fun `on invoke EXPECT listening language update in settings repository`() {
        useCase.invoke()

        verify(settingsRepository).listeningLanguageUpdate()
    }

    @Test
    fun `on invoke EXPECT complete`() {
        whenever(settingsRepository.listeningLanguageUpdate()).thenReturn(Flowable.just(locale))

        useCase()
                .test()
                .assertComplete()
    }

    @Test
    fun `on invoke EXPECT response list of loans`() {
        whenever(settingsRepository.listeningLanguageUpdate()).thenReturn(Flowable.just(locale))

        useCase()
                .test()
                .assertValue(locale)
    }

    @Test
    fun `on invoke EXPECT error`() {
        val response = Throwable("error")
        whenever(settingsRepository.listeningLanguageUpdate()).thenReturn(Flowable.error(response))

        useCase()
                .test()
                .assertError(response)
    }
}