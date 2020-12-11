package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.ui

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.di.module.AuthenticationPresentersModule
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation.IAuthenticationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.presentation.IAuthenticationView
import javax.inject.Inject

class AuthenticationFragment : Fragment(), IAuthenticationView {
    @Inject
    lateinit var presenter: IAuthenticationPresenter

    private lateinit var etNameUser: EditText
    private lateinit var etPasswordUser: EditText
    private lateinit var btnAuthentication: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_authentication, container, false)
        initView(fragmentLayout)
        return fragmentLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    private fun initPresenter() {
        (activity?.application as App)
                .getApplicationComponent()
                .newAuthenticationComponent(AuthenticationPresentersModule())
                .inject(this)
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        presenter.clear()
        super.onDestroy()
    }

    private fun initView(fragmentLayout: View) {
        etNameUser = fragmentLayout.findViewById(R.id.et_name_user_in_auth)
        etPasswordUser = fragmentLayout.findViewById(R.id.et_password_user_in_auth)
        btnAuthentication = fragmentLayout.findViewById(R.id.btn_authentication)
        btnAuthentication.setOnClickListener {
            presenter.onAuthenticationButtonClicked(
                    etNameUser.text.toString(),
                    etPasswordUser.text.toString()
            )
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(arguments)
    }

    override fun navigateToListOfLoansFragment() {
        navigateToDestinationScreen(R.id.action_authenticationFragment_to_listOfLoansFragment, this)
    }

    override fun navigateToExplanationAfterRegistrationFragment() {
        navigateToDestinationScreen(R.id.action_authenticationFragment_to_explanationAfterRegistrationFragment, this)
    }

    override fun showPassedValues(username: String, password: String) {
        etNameUser.setText(username)
        etPasswordUser.setText(password)
    }

    override fun showToast(message: String) =
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    override fun returnResources() = resources
}