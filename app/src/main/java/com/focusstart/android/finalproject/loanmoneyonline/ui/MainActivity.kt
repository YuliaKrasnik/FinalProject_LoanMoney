package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.focusstart.android.finalproject.loanmoneyonline.Constants.APP_PREFERENCES
import com.focusstart.android.finalproject.loanmoneyonline.Constants.APP_PREFERENCES_TOKEN
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

    private fun isSignedIn(): Boolean {
        if (getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).contains(
                APP_PREFERENCES_TOKEN
            )
        ) {
            val token = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getString(
                APP_PREFERENCES_TOKEN,
                ""
            )
            return token != "" && token != null
        }
        return false
    }

}