package com.focusstart.android.finalproject.loanmoneyonline.features.loans.features.listOsLoans.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.focusstart.android.finalproject.loanmoneyonline.R
import com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.Loan

class ItemViewHolder(val view: View, private val clickFunction: (Loan) -> Unit) : RecyclerView.ViewHolder(view) {

    private var tvDateLoan: TextView = view.findViewById(R.id.tv_date_loan)
    private var tvAmountLoan: TextView = view.findViewById(R.id.tv_amount_loan)
    private var tvStateLoan: TextView = view.findViewById(R.id.tv_state_loan)

    fun bind(data: Loan) {
        tvDateLoan.text = data.date
        tvAmountLoan.text = data.amount.toString()
        tvStateLoan.text = data.state
        view.setOnClickListener { clickFunction(data) }
    }
}