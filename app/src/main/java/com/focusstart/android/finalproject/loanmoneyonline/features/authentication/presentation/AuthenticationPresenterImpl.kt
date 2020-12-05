package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation

import android.os.Bundle
import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_REGISTRATION_NAME
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_REGISTRATION_PASSWORD
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.CODE_NOT_FOUND
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.AuthenticationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.SaveBearerTokenUseCase
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import retrofit2.Response

class AuthenticationPresenterImpl(
        private val authenticationUseCase: AuthenticationUseCase,
        private val saveBearerTokenUseCase: SaveBearerTokenUseCase
) :
        IAuthenticationPresenter {

    companion object {
        private const val MESSAGE_EMPTY_FIELDS = "Заполните все поля"
        private const val MESSAGE_USER_NOT_FOUND =
                "Не удается войти. Такого пользователя не существует"
    }

    private var view: IAuthenticationView? = null
    private val compositeDisposable = CompositeDisposable()

    private var isAuthenticationAfterRegistration = false

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun onAuthenticationButtonClicked(username: String, password: String) {
        if (validationOfEnteredValues(username, password))
            authenticationInApp(username, password)
        else view?.showToast(MESSAGE_EMPTY_FIELDS)
    }

    private fun validationOfEnteredValues(username: String, password: String) =
            username.isNotEmpty() && password.isNotEmpty()

    override fun onResume(arguments: Bundle?) {
        checkPassedValuesInBundle(arguments)
    }

    override fun <T> attachView(view: T) {
        this.view = view as IAuthenticationView
    }

    private fun checkPassedValuesInBundle(arguments: Bundle?) {
        isAuthenticationAfterRegistration = if (arguments != null) {
            automaticAuthentication(arguments)
            true
        } else false
    }

    private fun automaticAuthentication(arguments: Bundle) {
        val username = arguments.getString(BUNDLE_KEY_REGISTRATION_NAME)
        val password = arguments.getString(BUNDLE_KEY_REGISTRATION_PASSWORD)

        if (username != null && password != null) {
            view?.showPassedValues(username, password)
            authenticationInApp(username, password)
        }
    }

    private fun authenticationInApp(username: String, password: String) {
        authenticationUseCase(username, password)
                .compose(applySchedulers())
                .subscribe(object : SingleObserver<Response<ResponseBody>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<ResponseBody>) {
                        processingResponseAuthentication(response)
                    }

                    override fun onError(e: Throwable) {
                        Log.e(Constants.TAG_ERROR, "authentication in App: ${e.message}")
                    }
                })
    }

    private fun processingResponseAuthentication(response: Response<ResponseBody>) {
        if (response.isSuccessful) {
            val bearerToken = response.body()?.string()
            bearerToken?.let {
                saveBearerToken(bearerToken)
                navigationOnNextWindow()
            }
        } else {
            when (response.code()) {
                CODE_NOT_FOUND -> view?.showToast(MESSAGE_USER_NOT_FOUND)
            }
        }
    }

    private fun navigationOnNextWindow() {
        if (isAuthenticationAfterRegistration) {
            view?.navigateToExplanationAfterRegistrationFragment()
        } else {
            view?.navigateToListOfLoansFragment()
        }
    }

    private fun saveBearerToken(bearerToken: String) {
        saveBearerTokenUseCase(bearerToken)
    }

}