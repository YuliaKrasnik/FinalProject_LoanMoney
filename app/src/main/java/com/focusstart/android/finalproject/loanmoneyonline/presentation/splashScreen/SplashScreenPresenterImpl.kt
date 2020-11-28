package com.focusstart.android.finalproject.loanmoneyonline.presentation.splashScreen

import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.CheckingBearerTokenAvailabilityUseCase
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashScreenPresenterImpl(private val checkingBearerTokenAvailabilityUseCase: CheckingBearerTokenAvailabilityUseCase) :
        ISplashScreenPresenter {
    private var view: ISplashScreenView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onResume() {
        checkingBearerTokenAvailability()
    }

    private fun checkingBearerTokenAvailability() {
        val singleObservable = Single.just(checkingBearerTokenAvailabilityUseCase())
        singleObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(800, TimeUnit.MILLISECONDS)
                .subscribe(object : SingleObserver<Boolean> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(isTokenAvailability: Boolean) {
                        if (isTokenAvailability) view?.navigateToListOfLoansFragment()
                        else view?.navigateToStartFragment()
                    }

                    override fun onError(e: Throwable) {
                        //   TODO("Not yet implemented")
                    }

                })

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