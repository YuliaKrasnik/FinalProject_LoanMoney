package com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.repository

import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.dataSource.LoginDataSource
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.AuthNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.MapperAuthToAuthNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.MapperUserEntityNetworkToUserEntity
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.data.model.UserEntityNetwork
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.Auth
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.model.UserEntity
import com.focusstart.android.finalproject.loanmoneyonline.features.authentication.domain.repository.ILoginRepository
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

class LoginRepositoryImpl(
        private val dataSource: LoginDataSource
) : ILoginRepository {

    override fun registrationInApp(auth: Auth): Single<Response<UserEntity>> =
            dataSource.registrationInApp(mapperAuthToAuthNetwork(auth))
                    .map {
                        when (it.isSuccessful) {
                            true -> Response.success(mapperUserEntityNetworkToUserEntity(it.body()))
                            false -> Response.error(it.code(), it.errorBody() as ResponseBody)
                        }
                    }

    private fun mapperAuthToAuthNetwork(auth: Auth): AuthNetwork =
            MapperAuthToAuthNetwork().map(auth)

    private fun mapperUserEntityNetworkToUserEntity(userEntityNetwork: UserEntityNetwork?): UserEntity =
            MapperUserEntityNetworkToUserEntity().map(userEntityNetwork)


    override fun authentication(auth: Auth): Single<Response<ResponseBody>> =
            dataSource.authentication(mapperAuthToAuthNetwork(auth))

}