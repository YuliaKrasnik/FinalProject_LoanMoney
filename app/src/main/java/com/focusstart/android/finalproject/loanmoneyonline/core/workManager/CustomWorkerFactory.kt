package com.focusstart.android.finalproject.loanmoneyonline.core.workManager

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansFromNetworkUseCase

class CustomWorkerFactory(private val getListOfLoansFromNetworkUseCase: GetListOfLoansFromNetworkUseCase) :
    WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {

        val workerClass = Class.forName(workerClassName).asSubclass(Worker::class.java)
        val constructor =
            workerClass.getDeclaredConstructor(Context::class.java, WorkerParameters::class.java)
        val instance = constructor.newInstance(appContext, workerParameters)

        when (instance) {
            is NotificationForLoanRepaymentWorker -> {
                instance.getListOfLoansFromNetworkUseCase = getListOfLoansFromNetworkUseCase
            }
        }
        return instance
    }
}