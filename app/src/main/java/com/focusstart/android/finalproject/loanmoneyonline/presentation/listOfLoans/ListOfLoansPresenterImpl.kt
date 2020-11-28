package com.focusstart.android.finalproject.loanmoneyonline.presentation.listOfLoans

import com.focusstart.android.finalproject.loanmoneyonline.data.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.domain.usecase.GetListOfLoansUseCase
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class ListOfLoansPresenterImpl(private val getListOfLoansUseCase: GetListOfLoansUseCase) :
        IListOfLoansPresenter {
    private var view: IListOfLoansView? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onResume() {
        getListOfLoans()
    }

    private fun getListOfLoans() {
        getListOfLoansUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Response<List<Loan>>> {
                    override fun onSubscribe(disposable: Disposable) {
                        compositeDisposable.add(disposable)
                    }

                    override fun onSuccess(response: Response<List<Loan>>) {
                        val listOfLoans = response.body()
                        val code = response.code()
                        if (code == 200) {
                            listOfLoans?.let { view?.showLoans(it) }
                        }
                    }

                    override fun onError(e: Throwable) {
                        // TODO("Not yet implemented")
                    }
                })
    }

    override fun attachView(view: IListOfLoansView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun onCreateNewLoanButtonClicked() {
        view?.navigateToLoanRegistrationFragment()
    }

}