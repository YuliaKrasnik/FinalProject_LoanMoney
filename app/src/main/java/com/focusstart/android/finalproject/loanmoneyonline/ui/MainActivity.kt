package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.focusstart.android.finalproject.loanmoneyonline.Constants.APP_PREFERENCES
import com.focusstart.android.finalproject.loanmoneyonline.Constants.APP_PREFERENCES_TOKEN
import com.focusstart.android.finalproject.loanmoneyonline.Constants.TAG_DEBUG
import com.focusstart.android.finalproject.loanmoneyonline.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setStartFragment()
    }

    private fun setStartFragment() {
        if (isSignedIn()) {
            val navigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
            val graph = navigationController.graph
            graph.startDestination = R.id.listOfLoansFragment
            navigationController.graph = graph
        }
    }

    private fun isSignedIn(): Boolean { //TODO: работа с SharedPreferences в data слое. Для Activity тоже создавать presenter и тд, чтобы перенести эти методы в data слой?
        if (getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).contains(
                APP_PREFERENCES_TOKEN
            )
        ) {
            val token = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getString(
                APP_PREFERENCES_TOKEN,
                ""
            )
            token?.let { Log.d(TAG_DEBUG, it) }
            return token != "" && token != null
        }
        return false
    }

}