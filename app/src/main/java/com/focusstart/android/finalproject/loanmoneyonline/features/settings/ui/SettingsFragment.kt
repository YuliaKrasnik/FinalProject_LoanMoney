package com.focusstart.android.finalproject.loanmoneyonline.features.settings.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.focusstart.android.finalproject.loanmoneyonline.App
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.di.module.SettingsPresenterModule
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.presentation.ISettingsPresenter
import com.focusstart.android.finalproject.loanmoneyonline.features.settings.presentation.ISettingsView
import javax.inject.Inject

class SettingsFragment : Fragment(), ISettingsView {
    @Inject
    lateinit var presenter: ISettingsPresenter
    private lateinit var btnLogout: ImageButton
    private lateinit var rbRussianLanguage: RadioButton
    private lateinit var rbEnglishLanguage: RadioButton

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_settings, container, false)
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
                .newSettingsComponent(SettingsPresenterModule())
                .inject(this)
        presenter.attachView(this)
    }

    private fun initView(fragmentLayout: View) {
        btnLogout = fragmentLayout.findViewById(R.id.btn_logout)
        btnLogout.setOnClickListener { presenter.onLogoutButtonClicked() }

        rbRussianLanguage = fragmentLayout.findViewById(R.id.rb_russian_language)
        rbRussianLanguage.setOnClickListener { presenter.onRussianLanguageClicked() }
        rbEnglishLanguage = fragmentLayout.findViewById(R.id.rb_english_language)
        rbEnglishLanguage.setOnClickListener { presenter.onEnglishLanguageClicked() }
    }

    override fun onDestroy() {
        presenter.clear()
        presenter.detachView()
        super.onDestroy()
    }

    override fun logout() {
        navigateToDestinationScreen(
                R.id.action_settingsFragment_to_startFragment,
                this
        )
    }

    override fun comeBack() {
        popBackStackNavigation(this, R.id.listOfLoansFragment, false)
    }

}