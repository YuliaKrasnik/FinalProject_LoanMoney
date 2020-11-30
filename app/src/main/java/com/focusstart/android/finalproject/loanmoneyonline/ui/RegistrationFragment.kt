package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.IRegistrationPresenter
import com.focusstart.android.finalproject.loanmoneyonline.presentation.registrationUser.IRegistrationView
import javax.inject.Inject

class RegistrationFragment : Fragment(), IRegistrationView {
    @Inject
    lateinit var presenter: IRegistrationPresenter

    private lateinit var etNameUser: EditText
    private lateinit var etPasswordUser: EditText
    private lateinit var btnRegistration: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_registration, container, false)
        initView(fragmentLayout)
        return fragmentLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    private fun initPresenter() {
        activity?.application?.let { getPresentersComponent(it).inject(this) }
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        presenter.clear()
        super.onDestroy()
    }

    private fun initView(fragmentLayout: View) {
        etNameUser = fragmentLayout.findViewById(R.id.et_name_user)
        etPasswordUser = fragmentLayout.findViewById(R.id.et_password_user)
        btnRegistration = fragmentLayout.findViewById(R.id.btn_registration)
        btnRegistration.setOnClickListener {
            presenter.onRegistrationButtonClicked(
                    etNameUser.text.toString(),
                    etPasswordUser.text.toString()
            )
        }
    }

    override fun showToast(message: String) =
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()

    override fun showUserNameError(message: String) {
        etNameUser.error = message
    }

    override fun navigateToAuthenticationFragment(bundle: Bundle) {
        navigateToDestinationScreen(R.id.action_registrationFragment_to_authenticationFragment, this, bundle)
    }

}