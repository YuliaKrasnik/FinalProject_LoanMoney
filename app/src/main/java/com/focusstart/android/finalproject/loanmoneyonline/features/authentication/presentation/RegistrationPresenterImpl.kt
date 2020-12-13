package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation

import android.os.Bundle
import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.useCase.RegistrationInAppUseCase
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_REGISTRATION_NAME
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BUNDLE_KEY_REGISTRATION_PASSWORD
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.CODE_BAD_REQUEST
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.TAG_ERROR
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Response

class RegistrationPresenterImpl(
        private val registrationInAppUseCase: RegistrationInAppUseCase
) :
        IRegistrationPresenter {
    private var view: IRegistrationView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun onRegistrationButtonClicked(username: String, password: String) {
        if (validationOfEnteredValues(username, password))
            registrationInApp(createAuth(username, password))
        else showToast(R.string.message_empty_fields)
    }

    private fun showToast(messageId: Int) {
        val message = view?.returnResources()?.getString(messageId)
        message?.let { view?.showToast(it) }
    }

    override fun <T> attachView(view: T) {
        this.view = view as IRegistrationView
    }

    private fun createAuth(username: String, password: String) = Auth(username, password)

    private fun validationOfEnteredValues(username: String, password: String): Boolean =
            username.isNotEmpty() && password.isNotEmpty()

    private fun registrationInApp(auth: Auth) {
        registrationInAppUseCase(auth)
                .compose(applySchedulers())
                .subscribe({
                    processingResponseRegistration(it, auth)
                }, {
                    Log.e(TAG_ERROR, "registration in App: ${it.message}")
                })
                .addTo(compositeDisposable)
    }

    private fun processingResponseRegistration(
            response: Response<UserEntity>,
            auth: Auth
    ) {
        if (response.isSuccessful) {
            automaticallyAuthentication(auth)
        } else {
            when (response.code()) {
                CODE_BAD_REQUEST -> {
                    val message = view?.returnResources()?.getString(R.string.message_user_exists)
                    message?.let { view?.showUserNameError(it) }
                }
            }
        }
    }

    private fun automaticallyAuthentication(auth: Auth) {
        val bundle = Bundle()
        bundle.putString(BUNDLE_KEY_REGISTRATION_NAME, auth.name)
        bundle.putString(BUNDLE_KEY_REGISTRATION_PASSWORD, auth.password)
        view?.navigateToAuthenticationFragment(bundle)
    }

}