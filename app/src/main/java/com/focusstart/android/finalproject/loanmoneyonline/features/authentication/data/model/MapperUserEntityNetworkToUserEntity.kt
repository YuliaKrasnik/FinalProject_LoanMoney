package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model

import com.focusstart.android.finalproject.loanmoneyonline.core.data.converter.Mapper
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.UserEntity

class MapperUserEntityNetworkToUserEntity:Mapper<UserEntityNetwork?, UserEntity>{
    override fun map(input: UserEntityNetwork?): UserEntity {
        return UserEntity(
            input?.name.orEmpty(),
            input?.role.orEmpty()
        )
    }

}