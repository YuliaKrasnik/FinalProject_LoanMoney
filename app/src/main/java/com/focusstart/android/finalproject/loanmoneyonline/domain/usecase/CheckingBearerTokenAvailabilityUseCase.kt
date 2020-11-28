package com.focusstart.android.finalproject.loanmoneyonline.domain.usecase

import com.focusstart.android.finalproject.loanmoneyonline.domain.repository.ISharedPreferenceRepository

class CheckingBearerTokenAvailabilityUseCase(private val sharedPreferenceRepository: ISharedPreferenceRepository) {
    operator fun invoke(): Boolean =
        sharedPreferenceRepository.checkingBearerTokenAvailability()
}