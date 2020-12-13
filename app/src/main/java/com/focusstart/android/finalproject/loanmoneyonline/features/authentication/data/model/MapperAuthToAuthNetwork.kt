package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model

import com.focusstart.android.finalproject.loanmoneyonline.core.data.converter.Mapper
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.Auth

class MapperAuthToAuthNetwork : Mapper<Auth, AuthNetwork> {
    override fun map(input: Auth): AuthNetwork {
        return AuthNetwork(
                input.name,
                input.password
        )
    }

}