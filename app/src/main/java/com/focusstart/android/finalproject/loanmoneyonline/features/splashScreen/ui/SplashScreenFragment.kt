package com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.di.module.SplashScreenPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation.ISplashScreenPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.splashScreen.presentation.ISplashScreenView
import javax.inject.Inject

class SplashScreenFragment : Fragment(), ISplashScreenView {
    @Inject
    lateinit var presenter: ISplashScreenPresenter
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    override fun onDestroy() {
        presenter.detachView()
        presenter.clear()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    private fun initPresenter() {
        (activity?.application as App)
                .getApplicationComponent()
                .newSplashScreenComponent(SplashScreenPresentersModule())
                .inject(this)
        presenter.attachView(this)
    }

    override fun navigateToStartFragment() {
        navigateToDestinationScreen(R.id.action_splashScreenFragment_to_startFragment, this)
    }

    override fun navigateToListOfLoansFragment() {
        navigateToDestinationScreen(R.id.action_splashScreenFragment_to_listOfLoansFragment, this)
    }

}