package com.focusstart.android.finalproject.loanmoneyonline.useCase

import com.focusstart.android.finalproject.loanmoneyonline.core.domain.repository.ISettingsRepository
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.SetFlagFirstLaunchAppUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class SetFlagFirstLaunchAppUseCaseTest {
    private val settingsRepository: ISettingsRepository = mock()
    private val useCase = SetFlagFirstLaunchAppUseCase(settingsRepository)
    private val flag = true

    @Test
    fun `on invoke EXPECT set flag first launch app in settings repository`() {
        useCase.invoke(flag)

        verify(settingsRepository).setFlagFirstLaunchApp(flag)
    }
}