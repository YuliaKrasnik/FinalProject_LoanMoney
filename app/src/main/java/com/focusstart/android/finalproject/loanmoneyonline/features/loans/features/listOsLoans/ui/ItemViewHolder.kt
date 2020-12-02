package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.ui

import android.content.res.Resources
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan

class ItemViewHolder(
        val view: View,
        private val determineColorState: (String, Resources) -> Int,
        private val transformNameState: (String, Resources) -> String,
        private val transformDate: (String, Resources) -> String,
        private val clickFunction: (Loan) -> Unit) : RecyclerView.ViewHolder(view) {

    private var tvDateLoan: TextView = view.findViewById(R.id.tv_date_loan)
    private var tvAmountLoan: TextView = view.findViewById(R.id.tv_amount_loan)
    private var tvStateLoan: TextView = view.findViewById(R.id.tv_state_loan)

    fun bind(data: Loan) {
        tvDateLoan.text = transformDate(data.date, view.resources)
        tvAmountLoan.text = data.amount.toString()
        tvStateLoan.text = transformNameState(data.state, view.resources)
        tvStateLoan.setTextColor(determineColorState(data.state, view.resources))
        view.setOnClickListener { clickFunction(data) }
    }
}