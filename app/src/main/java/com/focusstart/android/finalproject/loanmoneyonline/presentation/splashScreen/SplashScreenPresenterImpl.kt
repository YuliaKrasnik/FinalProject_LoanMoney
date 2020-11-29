package com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen

import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.Constants
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.CheckingBearerTokenAvailabilityUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.applySchedulers
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class SplashScreenPresenterImpl(private val checkingBearerTokenAvailabilityUseCase: CheckingBearerTokenAvailabilityUseCase) :
        ISplashScreenPresenter {

    companion object {
        private const val DELAY_TIME = 800L
    }

    private var view: ISplashScreenView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onResume() {
        checkingBearerTokenAvailability()
    }

    private fun checkingBearerTokenAvailability() {
        Single.just(checkingBearerTokenAvailabilityUseCase())
                .delay(DELAY_TIME, TimeUnit.MILLISECONDS)
                .compose(applySchedulers())
                .subscribe(object : SingleObserver<Boolean> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(isTokenAvailability: Boolean) {
                        processingResponseCheckingBearerToken(isTokenAvailability)
                    }

                    override fun onError(e: Throwable) {
                        Log.e(Constants.TAG_ERROR, "checking bearer token availability: ${e.message}")
                    }

                })

    }

    private fun processingResponseCheckingBearerToken(isTokenAvailability: Boolean) {
        if (isTokenAvailability) view?.navigateToListOfLoansFragment()
        else view?.navigateToStartFragment()
    }

    override fun attachView(view: ISplashScreenView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}