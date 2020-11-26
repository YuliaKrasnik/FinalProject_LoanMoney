package com.focusstart.android.finalproject.loanmoneyonline.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.focusstart.android.finalproject.loanmoneyonline.R

class ExplanationAfterRegisterLoanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explanation_after_register_loan, container, false)
    }

}