package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.GetFlagFirstLaunchAppUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Test

class GetFlagFirstLaunchAppUseCaseTest {
    private val settingsRepository: ISettingsRepository = mock()
    private val useCase = GetFlagFirstLaunchAppUseCase(settingsRepository)

    @Test
    fun `on invoke EXPECT get flag first launch app in settings repository`() {
        useCase.invoke()

        verify(settingsRepository).getFlagFirstLaunchApp()
    }

    @Test
    fun `on invoke EXPECT return value from settings repository`() {
        whenever(settingsRepository.getFlagFirstLaunchApp()).thenReturn(true)

        val actual = useCase.invoke()

        val expected = true
        Assert.assertEquals(expected, actual)
    }
}