package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan

import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.Constants
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.GetConditionsLoanUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.LoanRegistrationUseCase
import com.focusstart.android.finalproject.loanmoneyonline.presentation.common.applySchedulers
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import retrofit2.Response

class LoanRegistrationPresenterImpl(private val loanRegistrationUseCase: LoanRegistrationUseCase,
                                    private val getConditionsLoanUseCase: GetConditionsLoanUseCase) :
        ILoanRegistrationPresenter {

    companion object {
        private const val STEP_VALUE_IN_SEEK_BAR = 1000
        private const val MESSAGE_EMPTY_FIELDS = "Заполните все поля"
    }

    private var view: ILoanRegistrationView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attachView(view: ILoanRegistrationView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun onResume() {
        getConditionsLoan()
    }

    private fun getConditionsLoan() {
        getConditionsLoanUseCase()
                .compose(applySchedulers())
                .subscribe(object : SingleObserver<Response<LoanConditions>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<LoanConditions>) {
                        processingResponseGettingConditionsLoan(response)
                    }

                    override fun onError(e: Throwable) {
                        Log.e(Constants.TAG_ERROR, "get conditions loan: ${e.message}")
                    }
                })
    }

    private fun processingResponseGettingConditionsLoan(response: Response<LoanConditions>) {
        if (response.isSuccessful) {
            val loanCondition = response.body()
            loanCondition?.let { view?.showConditions(it.percent, it.period, it.maxAmount) }
        }
    }

    override fun onRegistrationLoanButtonClicked(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String) {
        if (validationOfEnteredValues(firstName, secondName, phoneNumber, amount))
            registrationLoan(firstName, secondName, phoneNumber, amount, period, percent)
        else view?.showToast(MESSAGE_EMPTY_FIELDS)
    }

    private fun validationOfEnteredValues(firstName: String, secondName: String, phoneNumber: String, amount: String): Boolean =
            firstName.isNotEmpty() && secondName.isNotEmpty() && phoneNumber.isNotEmpty() && amount.isNotEmpty()

    override fun getTransformedProgressValueInSeekBar(progress: Int) = progress / STEP_VALUE_IN_SEEK_BAR * STEP_VALUE_IN_SEEK_BAR

    private fun registrationLoan(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String) {
        loanRegistrationUseCase(firstName, secondName, phoneNumber, amount, period, percent)
                .compose(applySchedulers())
                .subscribe(object : SingleObserver<Response<Loan>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<Loan>) {
                        processingResponseRegistrationLoan(response)
                    }

                    override fun onError(e: Throwable) {
                        Log.e(Constants.TAG_ERROR, "registration loan: ${e.message}")
                    }
                })
    }

    private fun processingResponseRegistrationLoan(response: Response<Loan>) {
        if (response.isSuccessful) {
            val loan = response.body()
            loan?.let { view?.navigateToExplanationAfterRegisterLoanFragment() }
        }
    }

}