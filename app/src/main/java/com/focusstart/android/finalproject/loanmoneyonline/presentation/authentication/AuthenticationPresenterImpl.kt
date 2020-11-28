package com.focusstart.android.finalproject.loanmoneyonline.presentation.authentication

import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.SaveBearerTokenInPreferencesUseCase
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

class AuthenticationPresenterImpl(
        private val authenticationUseCase: AuthenticationUseCase,
        private val saveBearerTokenInPreferencesUseCase: SaveBearerTokenInPreferencesUseCase) :
        IAuthenticationPresenter {
    private var view: IAuthenticationView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attachView(view: IAuthenticationView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun onAuthenticationButtonClicked(username: String, password: String) {
        authenticationInApp(username, password)
    }

    private fun authenticationInApp(username: String, password: String) {
        authenticationUseCase(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Response<ResponseBody>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<ResponseBody>) {
                        val bearerToken = response.body()?.string()
                        val code = response.code()
                        if (code == 200) {
                            bearerToken?.let {
                                saveBearerToken(bearerToken)
                            }
                            view?.navigateToListOfLoansFragment()
                        }
                    }

                    override fun onError(e: Throwable) {
                        // TODO("Not yet implemented")
                    }
                })
    }

    private fun saveBearerToken(bearerToken: String) {
        saveBearerTokenInPreferencesUseCase(bearerToken)
    }

}