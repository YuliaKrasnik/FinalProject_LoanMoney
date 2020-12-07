package com.focusstart.android.finalproject.loanmoneyonline.core.presentation.workManager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.core.ui.MainActivity
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.model.Loan
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.domain.useCase.GetListOfLoansFromNetworkUseCase
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.COUNT_MILLISECONDS_IN_DAY
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.COUNT_OF_DAYS_BEFORE_LOAN_EXPIRATION
import com.focusstart.android.finalproject.loanmoneyonline.utils.Constants.STATE_LOAN_FOR_NOTIFICATION
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class NotificationForLoanRepaymentWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(
    context,
    workerParams
) {
    private var listOfLoans: List<Loan> = mutableListOf()
    lateinit var getListOfLoansFromNetworkUseCase: GetListOfLoansFromNetworkUseCase

    override fun doWork(): Result {
        getListOfLoansFromNetwork()

        val countExpiringLoans = countExpiringLoans(listOfLoans)

        if (countExpiringLoans != 0) {
            sendNotification(countExpiringLoans)
        }
        return Result.success()
    }

    private fun sendNotification(countFindExpiringLoans: Int) {
        val contentIntent = createContentIntent()
        val text = createTextNotification(countFindExpiringLoans)
        val notificationManager = createNotificationManager()

        val notification =
            NotificationCompat.Builder(applicationContext, Constants.DEFAULT_ID_CHANNEL)
                .setContentTitle(applicationContext.resources.getString(R.string.title_notification))
                .setContentText(text)
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(contentIntent)
                .setStyle(NotificationCompat.BigTextStyle().bigText(text))
                .setAutoCancel(true)

        notificationManager.notify(Constants.DEFAULT_ID_NOTIFICATION, notification.build())
    }

    private fun createNotificationManager(): NotificationManager {
        val notificationManager: NotificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel(
                    Constants.DEFAULT_ID_CHANNEL,
                    Constants.DEFAULT_NAME_CHANNEL,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            notificationManager.createNotificationChannel(notificationChannel)
        }
        return notificationManager
    }

    private fun createTextNotification(countFindExpiringLoans: Int) =
        applicationContext.resources.getString(R.string.text_1_part_notification) + " " +
                applicationContext.resources.getString(R.string.text_2_part_notification) + " " + countFindExpiringLoans + ". " +
                applicationContext.resources.getString(R.string.text_3_part_notification)

    private fun createContentIntent(): PendingIntent {
        val notificationIntent = Intent(applicationContext, MainActivity::class.java)
        return PendingIntent.getActivity(
            applicationContext,
            0,
            notificationIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )
    }

    private fun getListOfLoansFromNetwork() {
        getListOfLoansFromNetworkUseCase()
            .subscribe({
                processingResponse(it)
            }, {
                Log.e(
                    Constants.TAG_ERROR,
                    "get list of loan in work manager from network: ${it.message}"
                )
            }).dispose()
    }

    private fun processingResponse(response: Response<List<Loan>>) {
        if (response.isSuccessful) {
            response.body()?.let {
                listOfLoans = it
            }
        }
    }

    private fun countExpiringLoans(listOfLoans: List<Loan>): Int {
        var count = 0
        listOfLoans.forEach { loan ->
            if (loan.state == STATE_LOAN_FOR_NOTIFICATION) {
                val isExpirationDate = checkExpirationDate(loan.date, loan.period)
                if (isExpirationDate) count++
            }
        }
        return count
    }

    private fun checkExpirationDate(date: String, period: Int): Boolean {
        val simpleDateFormat =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+HH:mm", Locale.getDefault())
        val dateLoan = simpleDateFormat.parse(date)

        val calendarCurrent = Calendar.getInstance(Locale.getDefault())
        val calendarLoan = Calendar.getInstance()
        if (dateLoan != null) {
            calendarLoan.time = dateLoan
            calendarLoan.add(Calendar.DATE, period)
        }

        val millisDifference = calendarLoan.timeInMillis - calendarCurrent.timeInMillis
        val daysDifference = millisDifference / COUNT_MILLISECONDS_IN_DAY

        return daysDifference <= COUNT_OF_DAYS_BEFORE_LOAN_EXPIRATION
    }
}