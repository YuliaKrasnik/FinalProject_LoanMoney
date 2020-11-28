package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser

import com.focusstart.android.finalproject.loanmoneyonline.data.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.SaveBearerTokenInPreferencesUseCase
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

class RegistrationPresenterImpl(
        private val registrationInAppUseCase: RegistrationInAppUseCase,
        private val authenticationUseCase: AuthenticationUseCase,
        private val saveBearerTokenInPreferencesUseCase: SaveBearerTokenInPreferencesUseCase) :
        IRegistrationPresenter {

    private var view: IRegistrationView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attachView(view: IRegistrationView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun onRegistrationButtonClicked(username: String, password: String) {
        registrationInApp(username, password)
    }

    private fun registrationInApp(username: String, password: String) {
        registrationInAppUseCase(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //TODO flatmap с login
                .subscribe(object : SingleObserver<Response<UserEntity>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<UserEntity>) {
                        val userEntity = response.body()
                        val code = response.code()
                        if (code == 200) {
                            automaticallyAuthentication(username, password)
                        }
                    }

                    override fun onError(e: Throwable) {
                    }
                })

    }

    private fun automaticallyAuthentication(username: String, password: String) {
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
                            view?.navigateToExplanationAfterRegistrationFragment()
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