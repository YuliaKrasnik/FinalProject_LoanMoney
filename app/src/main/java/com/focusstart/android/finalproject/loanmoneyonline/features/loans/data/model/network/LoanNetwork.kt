package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.network

data class LoanNetwork(
    val amount: Int,
    val date: String,
    val firstName: String,
    val id: Int,
    val lastName: String,
    val percent: Double,
    val period: Int,
    val phoneNumber: String,
    val state: String
)