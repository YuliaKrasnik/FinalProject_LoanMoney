package com.focusstart.android.finalproject.loanmoneyonline.core.data.converter

interface Mapper<I, O> {
    fun map(input: I): O
}