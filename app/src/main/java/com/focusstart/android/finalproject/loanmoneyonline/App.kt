package com.focusstart.android.finalproject.loanmoneyonline

import android.app.Application
import androidx.work.*
import com.focusstart.android.finalproject.loanmoneyonline.core.di.component.ApplicationComponent
import com.focusstart.android.finalproject.loanmoneyonline.core.di.component.DaggerApplicationComponent
import com.focusstart.android.finalproject.loanmoneyonline.core.di.module.*
import com.focusstart.android.finalproject.loanmoneyonline.core.workManager.NotificationForLoanRepaymentWorker
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.BASE_URL
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.FLEX_INTERVAL_IN_WORK_MANAGER
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.REPEAT_INTERVAL_IN_WORK_MANAGER
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.UNIQUE_NAME_WORK_NOTIFICATION
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class App : Application() {
    private var applicationComponent: ApplicationComponent? = null

    @Inject
    lateinit var workerFactory: WorkerFactory

    fun getApplicationComponent(): ApplicationComponent {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule(BASE_URL))
                .databaseModule(DatabaseModule())
                .settingsModule(SettingsModule())
                .workerModule(WorkerModule())
                .build()

        }
        return applicationComponent!!
    }

    override fun onCreate() {
        super.onCreate()
        getApplicationComponent().inject(this)
        configureWorkManager()

        runWorkManager()
    }

    private fun configureWorkManager() {
        val config = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
        WorkManager.initialize(this, config)
    }

    private fun runWorkManager() {
        val constrains = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val listWorkRequest = PeriodicWorkRequest.Builder(
            NotificationForLoanRepaymentWorker::class.java,
            REPEAT_INTERVAL_IN_WORK_MANAGER,
            TimeUnit.MINUTES,
            FLEX_INTERVAL_IN_WORK_MANAGER,
            TimeUnit.MINUTES
        )
            .setConstraints(constrains)
            .build()

        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            UNIQUE_NAME_WORK_NOTIFICATION,
            ExistingPeriodicWorkPolicy.KEEP,
            listWorkRequest
        )

    }


}