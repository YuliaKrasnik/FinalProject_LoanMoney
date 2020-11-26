package com.focusstart.android.finalproject.loanmoneyonline.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.focusstart.android.finalproject.loanmoneyonline.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegistrationFragment.newInstance())
                .commitNow()
        }
    }
}