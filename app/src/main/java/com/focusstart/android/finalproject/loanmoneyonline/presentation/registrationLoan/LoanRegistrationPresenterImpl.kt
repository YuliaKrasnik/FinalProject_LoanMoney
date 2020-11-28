package com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationLoan

import android.util.Log
import com.focusstart.android.finalproject.loanmoneyonline.Constants.TAG_DEBUG
import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.data.model.LoanConditions
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.GetConditionsLoanUseCase
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.LoanRegistrationUseCase
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class LoanRegistrationPresenterImpl(private val loanRegistrationUseCase: LoanRegistrationUseCase,
                                    private val getConditionsLoanUseCase: GetConditionsLoanUseCase) :
        ILoanRegistrationPresenter {
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Response<LoanConditions>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<LoanConditions>) {
                        val loanCondition = response.body()
                        val code = response.code()
                        if (code == 200) {
                            loanCondition?.let { view?.showConditions(it.percent, it.period, it.maxAmount) }
                        }
                    }

                    override fun onError(e: Throwable) {
                        // TODO("Not yet implemented")
                    }
                })
    }

    override fun onRegistrationLoanButtonClicked(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String) {
        registrationLoan(firstName, secondName, phoneNumber, amount, period, percent)
    }

    private fun registrationLoan(firstName: String, secondName: String, phoneNumber: String, amount: String, period: String, percent: String) {
        loanRegistrationUseCase(firstName, secondName, phoneNumber, amount, period, percent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Response<Loan>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<Loan>) {
                        val loan = response.body()
                        val code = response.code()
                        Log.d(TAG_DEBUG, code.toString())
                        if (code == 200) {
                            loan?.let { view?.navigateToExplanationAfterRegisterLoanFragment() }
                        } else {
                            view?.showToast("Попробуйте еще раз")
                        }
                    }

                    override fun onError(e: Throwable) {
                        // TODO("Not yet implemented")
                    }
                })
    }

}