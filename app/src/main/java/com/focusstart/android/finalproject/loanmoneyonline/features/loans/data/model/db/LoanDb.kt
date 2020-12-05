package com.focusstart.android.finalproject.loanmoneyonline.features.loans.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loan")
data class LoanDb(
    @PrimaryKey
    val id: Int,
    val amount: Int,
    val date: String,
    val firstName: String,
    val lastName: String,
    val percent: Double,
    val period: Int,
    val phoneNumber: String,
    val state: String
)