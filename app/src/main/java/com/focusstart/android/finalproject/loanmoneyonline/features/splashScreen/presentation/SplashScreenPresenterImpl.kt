package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation

import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.core.domain.useCase.SetFlagFirstLaunchAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.domain.useCase.CheckingBearerTokenAvailabilityUseCase
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import java.util.concurrent.TimeUnit

class SplashScreenPresenterImpl(
        private val checkingBearerTokenAvailabilityUseCase: CheckingBearerTokenAvailabilityUseCase,
        private val setFlagFirstLaunchAppUseCase: SetFlagFirstLaunchAppUseCase
) :
        ISplashScreenPresenter {

    companion object {
        private const val DELAY_TIME = 800L
    }

    private var view: ISplashScreenView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onResume() {
        setFlagFirstLaunchApp()
        checkingBearerTokenAvailability()
    }

    private fun setFlagFirstLaunchApp() {
        setFlagFirstLaunchAppUseCase(true)
    }

    private fun checkingBearerTokenAvailability() {
        Single.just(checkingBearerTokenAvailabilityUseCase())
                .delay(DELAY_TIME, TimeUnit.MILLISECONDS)
                .compose(applySchedulers())
                .subscribe({
                    processingResponseCheckingBearerToken(it)
                }, {
                    Log.e(Constants.TAG_ERROR, "checking bearer token availability: ${it.message}")
                })
                .addTo(compositeDisposable)
    }

    private fun processingResponseCheckingBearerToken(isTokenAvailability: Boolean) {
        if (isTokenAvailability) view?.navigateToListOfLoansFragment()
        else view?.navigateToStartFragment()
    }

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun <T> attachView(view: T) {
        this.view = view as ISplashScreenView
    }
}