package com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.di.module.StartWindowPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation.IStartWindowPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.startWindow.presentation.IStartWindowView
import javax.inject.Inject

class StartFragment : Fragment(), IStartWindowView {
    @Inject
    lateinit var presenter: IStartWindowPresenter

    private lateinit var btnOpenRegistrationWindow: Button
    private lateinit var btnOpenAuthenticationWindow: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_start, container, false)
        initView(fragmentLayout)
        return fragmentLayout
    }


    private fun initView(fragmentLayout: View) {
        btnOpenRegistrationWindow = fragmentLayout.findViewById(R.id.btn_open_registration_window)
        btnOpenRegistrationWindow.setOnClickListener { presenter.onRegistrationButtonClicked() }

        btnOpenAuthenticationWindow = fragmentLayout.findViewById(R.id.btn_open_login_window)
        btnOpenAuthenticationWindow.setOnClickListener { presenter.onAuthenticationButtonClicked() }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    private fun initPresenter() {
        (activity?.application as App)
                .getApplicationComponent()
                .newStartWindowComponent(StartWindowPresentersModule())
                .inject(this)
        presenter.attachView(this)
    }

    override fun navigateToAuthenticationFragment() {
        navigateToDestinationScreen(R.id.action_startFragment_to_authenticationFragment, this)
    }

    override fun navigateToRegistrationFragment() {
        navigateToDestinationScreen(R.id.action_startFragment_to_registrationFragment, this)
    }


}